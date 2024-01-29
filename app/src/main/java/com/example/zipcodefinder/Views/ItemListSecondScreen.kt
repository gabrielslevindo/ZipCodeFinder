package com.example.zipcodefinder.Views

import android.app.AlertDialog
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.zipcodefinder.R
import com.example.zipcodefinder.ViewModel.AddressViewModelRoom
import com.example.zipcodefinder.data.local.AddressLocal
import com.example.zipcodefinder.ui.theme.White
import com.example.zipcodefinder.ui.theme.shapesCardView


@Composable
fun ItemList(
    navController: NavController,
    position: Int,
    CEPList: MutableList<AddressLocal>,
    context: Context,
    viewModelRoom: AddressViewModelRoom = hiltViewModel()
) {

    val cep = CEPList[position].cep
    val Logradouro = CEPList[position].logradouro
    val Bairro = CEPList[position].bairro
    val Cidade = CEPList[position].localidade
    val Estado = CEPList[position].uf
    val id = CEPList[position].id


    fun AlertDaialogDeleteContact() {

        val alertDialog = AlertDialog.Builder(context)
        alertDialog.setTitle("Deseja Excluir?")
            .setMessage("Tem Certeza?")
        alertDialog.setPositiveButton("Ok") { _, _ ->


            viewModelRoom.deleteAddress(id)




            navController.navigate("SecondScreen")

            Toast.makeText(context, "Cep Removido com Sucesso!", Toast.LENGTH_SHORT).show()


        }
        alertDialog.setNegativeButton("Cancelar") { _, _ -> }
        alertDialog.show()


    }



    Card(

        colors = CardDefaults.cardColors(
            contentColor = White,
            containerColor = White,

            ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        ),
        shape = shapesCardView.medium,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp, 20.dp, 10.dp, 10.dp)


    ) {


        ConstraintLayout(

            modifier = Modifier.padding(20.dp)

        ) {

            val (CEP, logradouro, bairro, cidade, estado, delete) = createRefs()


            Text(text = "Cep: $cep",
                fontSize = 18.sp,
                color = Color.Black,
                modifier = Modifier.constrainAs(CEP) {


                    top.linkTo(parent.top, margin = 10.dp)
                    start.linkTo(parent.start, margin = 10.dp)

                }
            )
            Text(text = "Endereço: $Logradouro ",
                fontSize = 18.sp,
                color = Color.Black,
                modifier = Modifier.constrainAs(logradouro) {


                    top.linkTo(CEP.bottom, margin = 3.dp)
                    start.linkTo(parent.start, margin = 10.dp)


                }
            )
            Text(text = "Bairro: $Bairro ",
                fontSize = 18.sp,
                color = Color.Black,
                modifier = Modifier.constrainAs(bairro) {


                    top.linkTo(logradouro.bottom, margin = 3.dp)
                    start.linkTo(parent.start, margin = 10.dp)


                }
            )
            Text(text = "Cidade: $Cidade ",
                fontSize = 18.sp,
                color = Color.Black,
                modifier = Modifier.constrainAs(cidade) {


                    top.linkTo(bairro.bottom, margin = 3.dp)
                    start.linkTo(parent.start, margin = 10.dp)


                }
            )
            Text(text = "Estado: $Estado ",
                fontSize = 18.sp,
                color = Color.Black,
                modifier = Modifier.constrainAs(estado) {


                    top.linkTo(cidade.bottom, margin = 3.dp)
                    start.linkTo(parent.start, margin = 10.dp)


                }
            )

            Button(
                onClick = {


                          AlertDaialogDeleteContact()


                },


                modifier = Modifier.constrainAs(delete) {


                    start.linkTo(bairro.end, margin = 38.dp)
                    top.linkTo(bairro.top, margin = 10.dp)
                }, colors = ButtonDefaults.buttonColors(
                    containerColor = White
                )


            ){


                Image(
                    imageVector = ImageVector.vectorResource(id = R.drawable.baseline_delete_24),
                    contentDescription = "delete contac"
                )




            }


        }


    }


}