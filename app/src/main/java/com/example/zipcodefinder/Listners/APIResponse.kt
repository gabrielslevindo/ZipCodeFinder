package com.example.zipcodefinder.Listners

interface APIResponse{

    fun onSucess (logradouro: String, bairro: String, cidade: String, estado: String)
    fun onFailure(error:String)


}