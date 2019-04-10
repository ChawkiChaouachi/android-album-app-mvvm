package com.example.testandroidapplication.persistance

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*

import com.example.testandroidapplication.model.Album


@Dao
 abstract class AlbumsDao {


    @Query("SELECT * FROM albums")
    abstract fun findAll(): LiveData<List<Album>>

    @Update
    fun update(obj: List<Album>): List<Long> {
        return update(obj)
    }

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(obj: List<Album>): List<Long> {
        return insert(obj)
    }


    @Transaction
     open fun upsert(objList: List<Album>): Boolean {
        val insertResult = insert(objList)
        val updateList = ArrayList<Album>()

        for (i in insertResult.indices) {
            if (insertResult[i] < 0) {
                updateList.add(objList[i])
            }
        }

        if (!updateList.isEmpty()) {
            var responseList = update(updateList)
            if (responseList != null && responseList.isNotEmpty()) {
                return true
            }
        }
        return false
    }
}