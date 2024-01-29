package com.example.zipcodefinder.Views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColor
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.IconButtonDefaults
import com.example.zipcodefinder.Components.ButtonCuston
import com.example.zipcodefinder.R
import com.example.zipcodefinder.ViewModel.AddressViewModelRoom
import com.example.zipcodefinder.ui.theme.Green
import com.example.zipcodefinder.ui.theme.White

@OptIn(ExperimentalTvMaterial3Api::class, ExperimentalMaterial3Api::class)
@Composable
fun SecondScreen(
    navController: NavController,
    viewModelRoom: AddressViewModelRoom = hiltViewModel()
) {

    val CEPList = viewModelRoom.getAddress().collectAsState(mutableListOf()).value
    val context = LocalContext.current





    Scaffold(

        topBar = {

            TopAppBar(
                colors = TopAppBarDefaults.smallTopAppBarColors(

                    containerColor = Green,


                    ),
                title = {

                    androidx.compose.material3.Text(
                        text = "Buscador de CEP",
                        color = White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 22.sp
                    )
                }, navigationIcon = {

                    IconButton(



                        onClick = {

                        navController.navigate("FirstScreen")


                    }) {

                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.baseline_arrow_back_242),
                            contentDescription = null
                        )


                    }


                }


            )


        },


        ) {


        Column(

            modifier = Modifier.padding(it)

        ) {

            LazyColumn() {


                // Os itens esperam uma lambda com o item e com o position
                itemsIndexed(CEPList) { position, item ->

                    ItemList(navController, position, CEPList, context, viewModelRoom)


                }


            }


        }


    }


}



