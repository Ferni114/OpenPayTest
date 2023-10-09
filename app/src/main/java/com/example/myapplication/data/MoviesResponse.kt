package com.example.myapplication.data

import com.example.myapplication.data.Movie
import com.google.gson.annotations.SerializedName

data class MoviesResponse(
    @SerializedName("page")
    var page:Int,
    @SerializedName("results")
    var results:List<Movie>,
    @Transient
    var recycler:Int

)
