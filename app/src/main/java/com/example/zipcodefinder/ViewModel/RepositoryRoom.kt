package com.example.zipcodefinder.ViewModel

import com.example.zipcodefinder.data.local.AddressDao
import com.example.zipcodefinder.data.local.AddressLocal
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import okhttp3.Address
import javax.inject.Inject

@ViewModelScoped
class RepositoryRoom  @Inject constructor(private val addressDao: AddressDao){

    val getContact: Flow<MutableList<AddressLocal>> = addressDao.getAll()


    suspend fun saveAddress(addressList: MutableList<AddressLocal>){

        addressDao.insertAll(addressList)

    }

    suspend fun deleteAddress(id: Int){


        addressDao.deleteById(id)


    }


}