package com.example.zipcodefinder.data.remote

import android.widget.Toast
import com.example.zipcodefinder.Listners.APIResponseListners
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Inject

class DataSource @Inject constructor(){

    private val retrofit: APIResponse = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://viacep.com.br/").build().create(APIResponse::class.java)

    fun comeAPI(cep: String, API:APIResponseListners  ){


        if (cep.isEmpty()){

        API.onFailure("Preecha o Campo de CEP>")



        }else{



            retrofit.setAddress(cep).enqueue(object: Callback<addressResponse>{
                override fun onResponse(
                    call: Call<addressResponse>,
                    response: Response<addressResponse>
                ) {

                    if (response.code() == 200){

                        val logradouro = response.body()?.logradouro.toString()
                        val bairro = response.body()?.bairro.toString()
                        val localidade = response.body()?.localidade.toString()
                        val uf = response.body()?.uf.toString()

                    API.onSucess(logradouro,bairro,localidade,uf)

                    }else{

                        API.onFailure("CEP Invalido.")



                    }



                }

                override fun onFailure(call: Call<addressResponse>, t: Throwable) {
                   API.onFailure("SERVER ERROR.")
                }


            })




        }




    }




}