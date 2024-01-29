package com.example.zipcodefinder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.zipcodefinder.ViewModel.APIViewModel
import com.example.zipcodefinder.ViewModel.AddressViewModelRoom
import com.example.zipcodefinder.Views.FirstScrenn
import com.example.zipcodefinder.Views.SecondScreen
import com.example.zipcodefinder.ui.theme.ZipCodeFinderTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

   private lateinit var  viewModel: APIViewModel

   private lateinit var viewModelRoom: AddressViewModelRoom


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ZipCodeFinderTheme {


                val navController = rememberNavController()

                viewModel= hiltViewModel()
                viewModelRoom = hiltViewModel()



                NavHost(navController = navController, startDestination = "FirstScreen") {

                    composable("FirstScreen") {

                        FirstScrenn(navController, viewModel, viewModelRoom)


                    }
                    composable(
                        "SecondScreen",


                    ) {


                        SecondScreen(navController,viewModelRoom)

                    }


                }
            }
        }
    }
}

