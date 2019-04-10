package com.example.testandroidapplication.injection.repo

import android.arch.lifecycle.LiveData
import com.example.testandroidapplication.model.Album
import com.example.testandroidapplication.persistance.AlbumsDao
import javax.inject.Inject

class AlbumDataSource : AlbumRepositery{
    var albumDao : AlbumsDao

    @Inject
    constructor(albumDao: AlbumsDao) {
        this.albumDao = albumDao
    }



    override fun findAllAlbum(): LiveData<List<Album>> {
       return albumDao.findAll()
    }

    override fun insert(obj: List<Album>): List<Long> {
     return  albumDao.insert(obj)
    }

    override fun update(obj: List<Album>): List<Long> {
       return albumDao.update(obj)
    }

    override fun upsert(obj: List<Album>): Boolean {
        return albumDao.upsert(obj)
    }

}