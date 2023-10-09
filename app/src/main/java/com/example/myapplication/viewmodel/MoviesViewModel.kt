package com.example.myapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.domain.APIService
import com.example.myapplication.data.MoviesResponse
import com.example.myapplication.utils.APIClient

class MoviesViewModel : ViewModel() {
    val moviepopularsmodel = MutableLiveData<MoviesResponse>()
    val moviequalifiedsmodel = MutableLiveData<MoviesResponse>()
    val movienextmodel = MutableLiveData<MoviesResponse>()

    suspend fun loadPopulars() {
        var array= APIClient.getRetrofit()?.create(APIService::class.java)?.getMovies("popular")
        var resp=array?.body() as MoviesResponse
        resp.recycler=0
        moviepopularsmodel.postValue(resp)
    }

    suspend fun loadQualifieds() {
        var array = APIClient.getRetrofit()?.create(APIService::class.java)?.getMovies("top_rated")
        var resp=array?.body() as MoviesResponse
        resp.recycler=1
        moviequalifiedsmodel.postValue(resp)
    }

    suspend fun loadNext() {
        var array = APIClient.getRetrofit()?.create(APIService::class.java)?.getMovies("upcoming")
        var resp=array?.body() as MoviesResponse
        resp.recycler=2
        movienextmodel.postValue(resp)
    }
}