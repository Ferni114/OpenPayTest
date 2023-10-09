package com.example.myapplication.domain

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.myapplication.data.UserEntity

@Dao
interface UserDAO {
    @Query("select * from Users")
    fun getUsers():List<UserEntity>

    @Query("select *from Users where id=:id")
    fun getUser(id:Int): UserEntity

    @Insert
    fun insertUser(user: UserEntity):Unit
}