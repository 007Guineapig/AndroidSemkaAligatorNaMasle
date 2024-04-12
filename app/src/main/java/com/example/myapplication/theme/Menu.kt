package com.example.myapplication.theme

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons.Filled
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.R
import com.example.myapplication.model.Affirmation
import com.example.myapplication.model.Datasource
import com.example.myapplication.theme.LastScreen
import com.example.myapplication.theme.Recept
import com.example.myapplication.ui.theme.MyApplicationTheme


@Composable
fun Menu(navController: NavHostController){


            Greetings(affirmationList = Datasource().loadAffirmations(), NavController = navController)
        }

/*@Composable
fun MyApp(modifier: Modifier = Modifier,navController: NavHostController) {
    var shouldShowOnboarding by rememberSaveable { mutableStateOf(true) }
}*/



@Composable
private fun Greetings(
    modifier: Modifier = Modifier,affirmationList: List<Affirmation> ,NavController : NavHostController

) {
    LazyColumn(modifier = modifier.padding(vertical = 4.dp)) {

        items(affirmationList) { affirmation ->

            Greeting(affirmation = affirmation,"ahoj",NavController)


        }
    }
}
@Composable
fun Greeting(affirmation: Affirmation,name: String, navController: NavHostController,modifier: Modifier = Modifier) {
    val ahoj =stringResource(affirmation.stringResourceId)
    val ahoj1 =affirmation.imageResourceId
    val ahoj2 = ("Composem ipsum color sit lazy, " +
            "padding theme elit, sed do bouncy. ").repeat(4)
    Card(

        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),

        modifier = modifier
            .clickable(onClick = {navController.navigate(Screen.Recept.rout+"/$ahoj/$ahoj1/$ahoj2")}) // Add clickable modifier here
            .padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Column{
            Image(
                painter = painterResource(affirmation.imageResourceId),
                contentDescription = stringResource(affirmation.stringResourceId),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp),
                contentScale = ContentScale.Crop
            )
            CardContent(ahoj)

        }
    }
}


@Preview
@Composable
fun prevcomb(){
    val navController = rememberNavController()
    Greetings(affirmationList = Datasource().loadAffirmations(), NavController = navController)
}
@Composable
private fun CardContent(name: String) {
    var expanded by rememberSaveable { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .padding(12.dp)
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(12.dp)
        ) {
            Text(text = "Hello, ")
            Text(
                text = name, style = MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = FontWeight.ExtraBold
                )
            )
            if (expanded) {
                Text(
                    text = ("Composem ipsum color sit lazy, " +
                            "padding theme elit, sed do bouncy. ").repeat(4),
                )
            }
        }
        IconButton(onClick = { expanded = !expanded }) {
            Icon(
                imageVector = if (expanded) Filled.KeyboardArrowUp else Filled.KeyboardArrowDown,
                contentDescription = if (expanded) {
                    stringResource(R.string.show_less)
                } else {
                    stringResource(R.string.show_more)
                }
            )
        }
    }
}