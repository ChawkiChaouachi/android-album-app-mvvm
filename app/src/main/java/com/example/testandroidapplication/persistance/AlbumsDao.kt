package com.example.testandroidapplication.persistance

import android.arch.persistence.room.*
import com.example.testandroidapplication.model.Album


@Dao
interface AlbumsDao {


    @Query("SELECT * FROM albums")
    fun findAll(): List<Album>

    @Update
    fun update(obj: List<Album>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(obj: List<Album>)
}
