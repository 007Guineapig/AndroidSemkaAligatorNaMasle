package com.example.myapplication


import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.foundation.layout.fillMaxWidth

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface

import androidx.compose.ui.Modifier
import androidx.navigation.NavType

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.myapplication.model.Affirmation
//import com.example.myapplication.model.Affirmation

import com.example.myapplication.theme.LastScreen
import com.example.myapplication.theme.Menu
import com.example.myapplication.theme.Recept
import com.example.myapplication.theme.Screen
import com.example.myapplication.theme.Uvod
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(modifier = Modifier.fillMaxWidth(),color = MaterialTheme.colorScheme.background){

            val navController = rememberNavController()
                NavHost(navController=navController,
                    startDestination = Screen.Uvod.rout
                ){
                    composable(Screen.Menu.rout){
                        Menu(navController = navController)
                    }

                   composable(Screen.Recept.rout+ "/{Nazov}/{jpg}/{ingrediencie}",
                       arguments=listOf(
                           navArgument("Nazov"){type = NavType.StringType },
                           navArgument("jpg"){type = NavType.IntType },
                           navArgument("ingrediencie"){type = NavType.StringType },

                   ))
                   {backStackEntry->
                       val Nazov = backStackEntry.arguments?.getString("Nazov")
                        Recept(navController = navController,backStackEntry=backStackEntry)
                    }
                    composable(Screen.LastScreen.rout){
                        LastScreen(navController = navController)
                    }
                    composable(Screen.Uvod.rout){
                        Uvod(navController = navController)
                    }
            }
        }
    }
    }
    }
}



