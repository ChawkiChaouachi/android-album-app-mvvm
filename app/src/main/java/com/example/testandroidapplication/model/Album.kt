package com.example.testandroidapplication.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(
    tableName = "albums"
)
data class Album (
    @ColumnInfo
    val albumId : Int,
    @PrimaryKey
    val id : Int,
    @ColumnInfo
    val title : String,
    @ColumnInfo
    val url :String,
    @ColumnInfo
    val thumbnailUrl : String
)
