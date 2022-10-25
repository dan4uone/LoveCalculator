package com.example.mylovecalculator.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface LoveApi {
    @GET("getPercentage")
    fun calculateName(@Query("fname") fName:String,
                      @Query("sname") sName:String,
                      @Header("X-RapidAPI-Key") key:String="73d80c0228msh621627099080b16p1a262djsnb232a58e06f8",
                      @Header("X-RapidAPI-Host") host:String="love-calculator.p.rapidapi.com"

    ): Call<LoveModel>
}