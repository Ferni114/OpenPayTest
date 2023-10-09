package com.example.myapplication.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName="Users")
data class UserEntity(
    @PrimaryKey(autoGenerate=true)
    var id:Int ,
    var name:String ,
    var phone:String
)
