package com.example.zipcodefinder.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [AddressLocal::class], version = 1)
abstract class AppDataBase : RoomDatabase() {

    abstract fun addressDao(): AddressDao


}




