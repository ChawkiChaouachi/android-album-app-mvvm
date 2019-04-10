package com.example.testandroidapplication.injection.repo

import android.arch.lifecycle.LiveData
import com.example.testandroidapplication.model.Album


interface AlbumRepositery {

    fun findAllAlbum(): LiveData<List<Album>>

    fun insert(obj: List<Album>): List<Long>

    fun update(obj: List<Album>): List<Long>

    fun upsert(obj: List<Album>): Boolean
}