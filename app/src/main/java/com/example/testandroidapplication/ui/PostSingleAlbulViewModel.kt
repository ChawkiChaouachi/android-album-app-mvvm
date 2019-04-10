package com.example.testandroidapplication.ui

import android.arch.lifecycle.MutableLiveData
import com.example.testandroidapplication.base.BaseViewModel
import com.example.testandroidapplication.model.Album

class PostSingleAlbulViewModel :BaseViewModel() {
    private val title = MutableLiveData<String>()
    private val thumbnailUrl = MutableLiveData<String>()

    fun bind (album : Album) {
        title.value = album.title
        thumbnailUrl.value = album.thumbnailUrl
    }
    fun getthumbnailUrl():MutableLiveData<String>{
        return  thumbnailUrl;
    }


    fun gettitle() : MutableLiveData<String>{
        return title;
    }
}