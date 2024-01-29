package com.example.zipcodefinder.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.zipcodefinder.data.local.AddressLocal
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

  @HiltViewModel
class AddressViewModelRoom @Inject constructor(private val repositoryRoom: RepositoryRoom) :
    ViewModel() {

    private val _allAddress = MutableStateFlow<MutableList<AddressLocal>>(mutableListOf())
    private val allAddress: StateFlow<MutableList<AddressLocal>> = _allAddress


    fun saveAddress(addressList: MutableList<AddressLocal>) {


        viewModelScope.launch {


            repositoryRoom.saveAddress(addressList)


        }}

      fun deleteAddress(id: Int){


          viewModelScope.launch {



              repositoryRoom.deleteAddress(id)



          }



      }


        fun getAddress(): Flow<MutableList<AddressLocal>> {


            viewModelScope.launch {


                repositoryRoom.getContact.collect {


                    _allAddress.value = it


                }


            }

            return allAddress


        }






}

