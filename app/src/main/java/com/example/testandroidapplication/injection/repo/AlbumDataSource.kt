package com.example.testandroidapplication.injection.repo

import android.arch.lifecycle.LiveData
import android.util.Log
import com.example.testandroidapplication.model.Album
import com.example.testandroidapplication.persistance.AlbumsDao
import javax.inject.Inject

class AlbumDataSource : AlbumRepository{
    var albumDao : AlbumsDao

    @Inject
    constructor(albumDao: AlbumsDao) {
        this.albumDao = albumDao
    }



    override fun findAllAlbum(): List<Album> {
        Log.d("AlbumDataSource" , "Find All object ")
       return albumDao.findAll()
    }

    override fun insert(obj: List<Album>) {
       albumDao.insert(obj)
    }

    override fun update(obj: List<Album>){
        albumDao.update(obj)
    }


}