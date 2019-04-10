package com.example.testandroidapplication.injection.module

import android.arch.persistence.room.Room
import android.content.Context
import com.example.testandroidapplication.injection.repo.AlbumDataSource
import com.example.testandroidapplication.injection.repo.AlbumRepository
import com.example.testandroidapplication.injection.repo.DemoDatabase
import com.example.testandroidapplication.persistance.AlbumsDao
import com.example.testandroidapplication.utils.DATA_BASE_NAME
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DaoModule {
    private lateinit var demoDatabase: DemoDatabase

    constructor(context: Context){
        demoDatabase = Room.databaseBuilder(context,DemoDatabase::class.java,DATA_BASE_NAME).build()

    }

    @Singleton
    @Provides
    internal fun providesRoomDatabase(): DemoDatabase {
        return demoDatabase
    }


    @Singleton
    @Provides
    internal fun provideAlbumRepository(albumsDao: AlbumsDao): AlbumRepository {
        return AlbumDataSource(albumsDao)
    }

    @Singleton
    @Provides
    internal fun providesAlbumDao(demoDatabase: DemoDatabase): AlbumsDao {
        return demoDatabase.albumDao
    }
}