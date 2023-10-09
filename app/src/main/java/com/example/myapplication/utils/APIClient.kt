package com.example.myapplication.utils

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIClient {
    companion object{
        var instance:Retrofit?=null

        fun getRetrofit(): Retrofit?{
            if(instance ==null) {
                instance =Retrofit.Builder()
                    .baseUrl("https://api.themoviedb.org/3/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return instance
        }
    }
}