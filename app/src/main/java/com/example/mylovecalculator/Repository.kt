package com.example.mylovecalculator


import android.os.Bundle
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.mylovecalculator.model.LoveModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Repository {

    fun getCalculate(fName:String,sName:String):MutableLiveData<LoveModel>{
        var liveLoveModel = MutableLiveData<LoveModel>()
        App.api.calculateName(fName, sName) .enqueue(object :Callback<LoveModel>{
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
               if (response.isSuccessful){
                   liveLoveModel.postValue(response.body())
               }
            }


            override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                Log.e("ololo","onFailure ${t.message}")
            }

        })
        return liveLoveModel
    }
}