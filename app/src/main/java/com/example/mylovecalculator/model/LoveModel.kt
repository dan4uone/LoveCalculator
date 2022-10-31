package com.example.mylovecalculator.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class LoveModel(
    @SerializedName("fname")
    val fName:String,
    @SerializedName("sname")
    val sName:String,
    val percentage:String,
    val result:String
): Serializable