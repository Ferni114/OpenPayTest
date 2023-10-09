package com.example.myapplication.data

import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("id")
    var id:Int,
    @SerializedName("title")
    var title:String,
    @SerializedName("release_date")
    var date:String,
    @SerializedName("poster_path")
    var picture:String
)
