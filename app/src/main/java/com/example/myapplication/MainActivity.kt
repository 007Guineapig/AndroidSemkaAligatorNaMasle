package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.theme.LastScreen
import com.example.myapplication.theme.Menu
import com.example.myapplication.theme.MyApp
import com.example.myapplication.theme.Recept
import com.example.myapplication.theme.Screen
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(modifier = Modifier.fillMaxWidth(),color = MaterialTheme.colorScheme.background){


            val navController = rememberNavController()

            NavHost(navController=navController,
                startDestination = Screen.Menu.rout
            ){
                composable(Screen.Menu.rout){
                    Menu(navController = navController)
                }
                composable(Screen.Recept.rout){
                    Recept(navController = navController)
                }
                composable(Screen.LastScreen.rout){
                    LastScreen(navController = navController)
                }
            }
            }
        }
    }
}