package com.example.mylovecalculator.prefs

import android.content.Context
import android.content.SharedPreferences

class Prefs(context: Context) {
    private var prefs :SharedPreferences =context.getSharedPreferences("setting",Context.MODE_PRIVATE)
    fun seveState(){
        prefs.edit().putBoolean("isShow",true).apply()
    }
    fun  isShow():Boolean{
        return prefs.getBoolean("isShow",false)
    }
}