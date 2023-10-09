package com.example.myapplication.data

import com.google.gson.annotations.SerializedName

data class UserResponse(
    @SerializedName("id")
    var id:Int ,
    @SerializedName("name")
    var name:String,
    @SerializedName("username")
    var username:String,
    @SerializedName("avatar")
    var avatar: AvatarResponse
){
    data class AvatarResponse(
        @SerializedName("tmdb")
        var tmdb: PathResponse,){
        data class PathResponse(
            @SerializedName("avatar_path")
            var path:String){}
    }
}
