package com.example.zipcodefinder.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.zipcodefinder.Listners.APIResponseListners
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class APIViewModel@Inject constructor(private val repositorio: repository): ViewModel() {

    fun respostAPI(cep:String, listners: APIResponseListners){


        viewModelScope.launch {


            repositorio.APIRESPOST(cep,listners)



        }



    }


}