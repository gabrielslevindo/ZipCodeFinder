package com.example.zipcodefinder.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class AddressLocal(

    val cep: String,
    val logradouro: String,
    val bairro: String,
    val localidade: String,
    val uf: String



){

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0



}
