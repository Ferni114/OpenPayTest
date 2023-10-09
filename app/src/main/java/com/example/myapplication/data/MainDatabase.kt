package com.example.myapplication.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myapplication.domain.UserDAO


@Database(entities=[UserEntity::class],version=1)
abstract class MainDatabase: RoomDatabase() {
    abstract suspend fun usersDao(): UserDAO

}