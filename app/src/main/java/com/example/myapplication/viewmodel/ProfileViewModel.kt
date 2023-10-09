package com.example.myapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.utils.APIClient
import com.example.myapplication.domain.APIService
import com.example.myapplication.data.UserResponse

class ProfileViewModel : ViewModel() {
    val usermodel = MutableLiveData<UserResponse>()

    suspend fun loadInformation() {
        var array = APIClient.getRetrofit()?.create(APIService::class.java)?.getUser()
        usermodel.postValue(array?.body() as UserResponse)
    }
}