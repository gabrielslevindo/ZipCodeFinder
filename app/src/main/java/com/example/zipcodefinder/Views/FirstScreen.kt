package com.example.zipcodefinder.Views

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.zipcodefinder.Components.ButtonCuston
import com.example.zipcodefinder.Components.OutlineTextFielCuston
import com.example.zipcodefinder.Listners.APIResponseListners
import com.example.zipcodefinder.ViewModel.APIViewModel
import com.example.zipcodefinder.ui.theme.Green
import com.example.zipcodefinder.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FirstScrenn(navController: NavController, viewModel:APIViewModel = hiltViewModel()) {



    val context = LocalContext.current

    var CEP by remember {
        mutableStateOf("")
    }
    var Endereco by remember {
        mutableStateOf("")
    }
    var Bairro by remember {
        mutableStateOf("")
    }
    var Cidade by remember {
        mutableStateOf("")
    }
    var Estado by remember {
        mutableStateOf("")
    }


    Scaffold(

        topBar = {

            TopAppBar(colors = TopAppBarDefaults.smallTopAppBarColors(

                containerColor = Green


            ), title = {

                Text(
                    text = "Buscador de CEP",
                    color = White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp
                )
            })
        },

        ) {


        Column(

            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {

            Row(

                modifier = Modifier.fillMaxWidth()

            ) {


                OutlineTextFielCuston(
                    value = CEP,
                    onValueChange = { CEP = it },
                    label = {

                        Text(text = "CEP")

                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number

                    ),
                    modifier = Modifier
                        .width(200.dp)
                        .padding(20.dp, 50.dp, 20.dp, 10.dp)
                )

                ButtonCuston(
                    onClick = {


                            viewModel.respostAPI(CEP, object : APIResponseListners{
                                override fun onSucess(
                                    logradouro: String,
                                    bairro: String,
                                    cidade: String,
                                    estado: String
                                ) {
                                    Endereco = logradouro
                                    Bairro = bairro
                                    Cidade = cidade
                                    Estado = estado


                                    Toast.makeText(context,"CEP encontrado com sucesso." , Toast.LENGTH_SHORT).show()



                                }

                                override fun onFailure(error: String) {
                                    Toast.makeText(context,"ERROR SERVER.." , Toast.LENGTH_SHORT).show()

                                }


                            })





                    },

                    Text = "Buscar CEP",

                    modifier = Modifier
                        .width(200.dp)
                        .padding(0.dp, 59.dp, 20.dp, 10.dp)
                        .height(55.dp)
                )


            }

            Column(

                modifier = Modifier.fillMaxWidth()

            ) {

                OutlineTextFielCuston(
                    value = Endereco,
                    onValueChange = {
                        Endereco = it
                    },
                    label = {

                        Text(text = "Endereço")

                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp, 0.dp, 20.dp, 10.dp)
                )
                OutlineTextFielCuston(
                    value = Bairro,
                    onValueChange = {
                        Bairro = it
                    },
                    label = {

                        Text(text = "Bairro")

                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp, 0.dp, 20.dp, 10.dp)
                )
                OutlineTextFielCuston(
                    value = Cidade,
                    onValueChange = {

                        Cidade = it

                    },
                    label = {

                        Text(text = "Cidade")

                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp, 0.dp, 20.dp, 10.dp)
                )
                OutlineTextFielCuston(
                    value = Estado,
                    onValueChange = {

                        Estado = it

                    },
                    label = {

                        Text(text = "Estado")

                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text
                    ),
                    modifier = Modifier
                        .width(165.dp)
                        .padding(20.dp, 0.dp, 20.dp, 10.dp)
                )
                ButtonCuston(

                    onClick = { },

                    Text = "AVANÇAR",

                    modifier = Modifier
                        .padding(20.dp)
                        .height(55.dp)

                )


            }


        }
    }


}

@Composable
@Preview
private fun previewFirst() {


 //   FirstScrenn(navController = rememberNavController(), viewModel = ViewModel)


}