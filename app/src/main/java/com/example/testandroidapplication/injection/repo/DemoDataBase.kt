package com.example.testandroidapplication.injection.repo

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.testandroidapplication.model.Album
import com.example.testandroidapplication.persistance.AlbumsDao
import com.example.testandroidapplication.utils.VERSION


@Database(entities = [Album::class], version = VERSION,exportSchema = false)

abstract class DemoDatabase : RoomDatabase() {
    abstract val albumDao: AlbumsDao
}
