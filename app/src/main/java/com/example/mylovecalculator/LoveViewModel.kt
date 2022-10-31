package com.example.mylovecalculator

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.mylovecalculator.model.LoveModel

class LoveViewModel:ViewModel() {
    val  repository = Repository()
    fun getLiveModel(fName:String,sName:String):LiveData<LoveModel>{
        return repository.getCalculate(fName,sName)
    }
}