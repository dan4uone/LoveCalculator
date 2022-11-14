package com.example.mylovecalculator.repository


import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.mylovecalculator.network.LoveApi
import com.example.mylovecalculator.model.LoveModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


class Repository @Inject constructor(private var api: LoveApi){
    @SuppressLint("SuspiciousIndentation")
    fun getCalculate(fName:String, sName:String):MutableLiveData<LoveModel>{
        val liveLoveModel = MutableLiveData<LoveModel>()
            api.calculateName(fName, sName) .enqueue(object :Callback<LoveModel>{
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