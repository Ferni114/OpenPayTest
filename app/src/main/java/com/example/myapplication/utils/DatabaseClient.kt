package com.example.myapplication.utils


import android.content.Context
import androidx.room.Room
import com.example.myapplication.data.MainDatabase

class DatabaseClient
{
    companion object{
        private lateinit  var instance: MainDatabase

        fun getRoom(context:Context): MainDatabase {
            if(instance ==null){
                instance = Room.databaseBuilder(context, MainDatabase ::class.java, "database").build()
            }
            return instance
        }
    }
}