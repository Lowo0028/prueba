package com.example.amilimetros

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.amilimetros.navigation.NavGraph
import com.example.amilimetros.ui.theme.AMilimetrosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AMilimetrosTheme {
                val navController = rememberNavController()
                NavGraph(navController = navController)
            }
        }
    }
}
