package com.example.testandroidapplication.ui

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider

class ViewModelFactory() : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PostAlbumsViewModel::class.java)) {

            @Suppress("UNCHECKED_CAST")
            return PostAlbumsViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")

    }
}