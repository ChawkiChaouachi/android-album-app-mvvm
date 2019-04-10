package com.example.testandroidapplication.ui

import android.arch.lifecycle.MutableLiveData
import com.example.testandroidapplication.base.BaseViewModel
import com.example.testandroidapplication.model.Album

class PostSingleAlbumViewModel :BaseViewModel() {
    private val title = MutableLiveData<String>()
    private val thumbnailUrl = MutableLiveData<String>()

    fun bind (album : Album) {
        title.value = album.title
        thumbnailUrl.value = album.thumbnailUrl
    }

    fun getUrl():MutableLiveData<String>{
        return  thumbnailUrl
    }


    fun getValueTitle() : MutableLiveData<String>{
        return title
    }

}