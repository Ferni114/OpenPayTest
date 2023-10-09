package com.example.myapplication.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName="Populars")
data class PopularsEntity(
    @PrimaryKey(autoGenerate=true)
    var id:Int,
    var picture:String,
    var title:String,
    var date:String
)

@Entity(tableName="Qualifieds")
data class QualifiedsEntity(
    @PrimaryKey(autoGenerate=true)
    var id:Int,
    var picture:String,
    var title:String,
    var date:String
)

@Entity(tableName="Next")
data class NextEntity(
    @PrimaryKey(autoGenerate=true)
    var id:Int,
    var picture:String,
    var title:String,
    var date:String
)