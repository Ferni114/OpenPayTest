package com.example.myapplication.domain

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.myapplication.data.NextEntity
import com.example.myapplication.data.PopularsEntity
import com.example.myapplication.data.QualifiedsEntity
import com.example.myapplication.data.UserEntity

@Dao
interface UserDAO {
    @Query("select * from User")
    fun getUsers():List<UserEntity>

    @Query("select *from Populars ")
    fun getPopulars(): List<PopularsEntity>

    @Query("select *from Qualifieds ")
    fun getQualifieds(): List<QualifiedsEntity>

    @Query("select *from Next ")
    fun getNext(): List<NextEntity>

    @Insert
    fun setPopulars(list:List<PopularsEntity>)
    @Insert
    fun setQualifieds(list:List<QualifiedsEntity>)

    @Insert
    fun setNext(list:List<NextEntity>)

}