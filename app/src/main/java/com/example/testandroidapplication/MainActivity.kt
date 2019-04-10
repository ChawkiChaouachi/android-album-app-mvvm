package com.example.testandroidapplication

import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.testandroidapplication.ui.PostAlbumsViewModel
import com.example.testandroidapplication.ui.ViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: PostAlbumsViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProviders.of(this, ViewModelFactory()).get(PostAlbumsViewModel::class.java)

    }
}
