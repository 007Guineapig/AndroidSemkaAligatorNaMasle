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

//class Menu : ComponentActivity(navController:NavHostController) {
  //  override fun onCreate(savedInstanceState: Bundle?) {
    //    super.onCreate(savedInstanceState)
      //  setContent {

        //    MyApplicationTheme {
          //      MyApp(modifier = Modifier.fillMaxSize())
           // }
        //}
    //}
//}
@Composable
fun Menu(navController: NavHostController){

   //MyApp(modifier = Modifier.fillMaxSize(),navController)
            Greetings(affirmationList = Datasource().loadAffirmations(), NavController = navController)
        }

@Composable
fun MyApp(modifier: Modifier = Modifier,navController: NavHostController) {
    var shouldShowOnboarding by rememberSaveable { mutableStateOf(true) }

    //Surface(modifier, color = MaterialTheme.colorScheme.background) {
        //if (shouldShowOnboarding) {
          //  OnboardingScreen(onContinueClicked = { shouldShowOnboarding = false })
        //} else {
            //Greetings(affirmationList = Datasource().loadAffirmations(),navController)
        //}
    //}
}

@Composable
fun OnboardingScreen(
    onContinueClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Welcome to the Basics Codelab!")
        Button(
            modifier = Modifier.padding(vertical = 24.dp),
            onClick = onContinueClicked
        ) {
            Text("Continue")
        }
    }
}

@Composable
private fun Greetings(
    modifier: Modifier = Modifier,affirmationList: List<Affirmation> ,NavController : NavHostController

) {
    LazyColumn(modifier = modifier.padding(vertical = 4.dp)) {
        //items(items = affirmationList) { name ->
        //  Greeting(items,name = name)
        //}
        items(affirmationList) { affirmation ->
            //AffirmationCard(
            Greeting(affirmation = affirmation,"ahoj",NavController)
            //    affirmation = affirmation,
            //    modifier = Modifier.padding(8.dp)

        }
    }
}





/*@Preview
@Composable
private fun PreviewGreeting(){
    Greeting(affirmation = Affirmation(R.string.affirmation1, R.drawable.image1),"ahoj")
}*/

@Composable
fun Greeting(affirmation: Affirmation,name: String, navController: NavHostController,modifier: Modifier = Modifier) {


    Card(

        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        modifier = modifier
            .clickable(onClick = {navController.navigate(Screen.Recept.rout)}) // Add clickable modifier here
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
            CardContent(name)

        }
    }
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



@Preview(
    showBackground = true,
    widthDp = 320,
    uiMode = UI_MODE_NIGHT_YES,
    name = "GreetingPreviewDark"
)
/*@Preview(showBackground = true, widthDp = 320)
@Composable
fun GreetingPreview() {
    MyApplicationTheme{
        Greetings(affirmationList = Datasource().loadAffirmations())
    }
}*/

@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun OnboardingPreview() {
    MyApplicationTheme {
        OnboardingScreen(onContinueClicked = {})
    }
}

//@Preview
//@Composable
//fun MyAppPreview() {
  //  MyApplicationTheme {
    //    MyApp(Modifier.fillMaxSize())
    //}
