package com.example.testandroidapplication.injection.repo

import android.arch.lifecycle.LiveData
import com.example.testandroidapplication.model.Album


interface AlbumRepository {

    fun findAllAlbum(): List<Album>

    fun insert(obj: List<Album>)

    fun update(obj: List<Album>)


}