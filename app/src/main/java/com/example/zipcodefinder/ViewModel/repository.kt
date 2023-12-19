package com.example.zipcodefinder.ViewModel

import com.example.zipcodefinder.Listners.APIResponseListners
import com.example.zipcodefinder.data.remote.DataSource
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject
@ViewModelScoped
class repository@Inject constructor(private val dataSource: DataSource) {



    fun APIRESPOST(cep: String, apiResponseListners: APIResponseListners){


      dataSource.comeAPI(cep,apiResponseListners)


    }







}