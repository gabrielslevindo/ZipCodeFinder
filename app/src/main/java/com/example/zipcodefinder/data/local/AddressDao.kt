package com.example.zipcodefinder.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface AddressDao {


    @Insert
   suspend fun insertAll(CepList: MutableList<AddressLocal>)

    @Query("SELECT * FROM addresslocal")
    fun getAll(): Flow<MutableList<AddressLocal>>

    @Query("DELETE from addresslocal WHERE id = :id ")
    suspend fun deleteById (id: Int)




}