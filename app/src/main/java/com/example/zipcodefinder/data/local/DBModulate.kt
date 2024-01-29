package com.example.zipcodefinder.data.local

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DBModulate {

    @Singleton
    @Provides
    fun provideDB(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(


        context,
        AppDataBase::class.java,
        "Address-DataBase"
    ).build()

    @Singleton
    @Provides
    fun providesDao(dataBase: AppDataBase) = dataBase.addressDao()






}