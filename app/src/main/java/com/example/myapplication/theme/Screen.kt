package com.example.myapplication.theme

sealed class Screen(val rout:String) {
    object Menu:Screen("Menu")
    object Recept:Screen("Recept")
    object LastScreen:Screen("LastScreen")
}