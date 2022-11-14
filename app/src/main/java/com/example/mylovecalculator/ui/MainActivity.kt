package com.example.mylovecalculator.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.mylovecalculator.R
import com.example.mylovecalculator.prefs.Prefs
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
@Inject
 lateinit var prefs: Prefs
 lateinit var navController:NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        prefs.seveState()
        if (prefs.isShow()){
            navController.navigate(R.id.homeFragment)
        }
    }




}