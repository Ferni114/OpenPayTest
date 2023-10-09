package com.example.myapplication.domain

import com.example.myapplication.data.MoviesResponse
import com.example.myapplication.data.UserResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface APIService {
    @Headers("Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI3ZTJiMDdhYWM3ODQ1YTM5MjI5N2FmOGZiYTUwYTQ3MSIsInN1YiI6IjY1MjA0Njk3OTY3Y2M3MzQyNDZhMGRiMyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.qbFTXEcigRT7yKrdp4Js0IalNNOBNXuG-Q-A7p4TCzk")
    @GET("account/20535486")
    suspend fun getUser():Response<UserResponse>

    @Headers("Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI3ZTJiMDdhYWM3ODQ1YTM5MjI5N2FmOGZiYTUwYTQ3MSIsInN1YiI6IjY1MjA0Njk3OTY3Y2M3MzQyNDZhMGRiMyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.qbFTXEcigRT7yKrdp4Js0IalNNOBNXuG-Q-A7p4TCzk")
    @GET("movie/{category}?language=en-US&page=1")
    suspend fun getMovies(@Path("category") category:String):Response<MoviesResponse>

}