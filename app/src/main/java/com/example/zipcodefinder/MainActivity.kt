package com.example.zipcodefinder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.zipcodefinder.Views.FirstScrenn
import com.example.zipcodefinder.Views.SecondScreen
import com.example.zipcodefinder.ui.theme.Green
import com.example.zipcodefinder.ui.theme.ZipCodeFinderTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ZipCodeFinderTheme {


                val navController = rememberNavController()
            //    val viewModel: ViewModelAPI = hiltViewModel()

                NavHost(navController = navController, startDestination = "FirstScreen") {

                    composable("FirstScreen") {

                        FirstScrenn(navController)


                    }
                    composable("SecondScreen") {


                        SecondScreen(navController)

                    }


                }
            }
        }
    }
}

