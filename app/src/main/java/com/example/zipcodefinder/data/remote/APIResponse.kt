package com.example.zipcodefinder.data.remote

import okhttp3.Address
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface APIResponse {

    @GET("ws/{cep}/json/")
    fun setAddress(@Path("cep") cep:String):Call<addressResponse>



}