package com.example.mylovecalculator.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable
@Entity(tableName = "love_table")
data class LoveModel(
    @SerializedName("fname")
    val fName:String,
    @SerializedName("sname")
    val sName:String,
    val percentage:String,
    val result:String,
    @PrimaryKey(autoGenerate = true)
    val id:Int? = 0
): Serializable