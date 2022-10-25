package com.example.mylovecalculator

import android.app.Application
import com.example.mylovecalculator.model.LoveApi
import com.example.mylovecalculator.model.RetrofitService


class App: Application() {
        companion object{
            lateinit var api: LoveApi
        }
        override fun onCreate() {
            super.onCreate()
            api = RetrofitService().api
        }
    }
