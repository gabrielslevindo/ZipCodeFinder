package com.example.zipcodefinder.Listners

interface APIResponseListners{

    fun onSucess (logradouro: String, bairro: String, cidade: String, estado: String)
    fun onFailure(error:String)


}