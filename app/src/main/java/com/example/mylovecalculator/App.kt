package com.example.mylovecalculator

import android.app.Application
import androidx.room.Room
import com.example.mylovecalculator.network.LoveApi
import com.example.mylovecalculator.room.AppDataBase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App: Application() {
    companion object{
        lateinit var appDataBase: AppDataBase
        lateinit var api: LoveApi
    }
    override fun onCreate() {
        super.onCreate()
        api = RetrofitService().api

        appDataBase = Room.databaseBuilder(applicationContext,AppDataBase::class.java,"love_base").
        allowMainThreadQueries().build()

    }
}


