package com.example.mylovecalculator.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mylovecalculator.model.LoveModel

@Database(entities = [LoveModel::class], version = 1)
abstract class AppDataBase :RoomDatabase() {

    abstract fun loveDao():Dao
}