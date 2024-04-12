package com.example.myapplication.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import com.example.myapplication.R

@Composable
fun Recept(navController: NavHostController,
           backStackEntry: NavBackStackEntry){

    val Nazov = backStackEntry.arguments?.getString("Nazov")
    val jpg = backStackEntry.arguments?.getInt("jpg")
    val ingrediencie = backStackEntry.arguments?.getString("ingrediencie")
    val imageResourceId: Int = jpg ?: R.drawable.image1
    Column(

    ){Box(modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.BottomStart) {
        Image(
            //painter = painterResource(R.drawable.image11),

            painter = painterResource(imageResourceId),
            contentDescription = "stringResource()",
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp),
            contentScale = ContentScale.Crop

        )
        Text(
            text = "$Nazov",
            fontSize = 40.sp,
            modifier = Modifier.padding(15.dp),
            color = Color.White,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Start

        )
        Spacer(modifier = Modifier.height(16.dp))

    }
        if (ingrediencie != null) {
            Text(
                text =ingrediencie,
                modifier = Modifier.padding(20.dp),
                textAlign = TextAlign.Start


            )
        }
        Button(onClick =
        {
            navController.navigate(Screen.LastScreen.rout)


        }
        )
        {
            Text(
                text = "Go to Last",
            )
        }




    }












}