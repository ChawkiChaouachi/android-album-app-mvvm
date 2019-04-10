package com.example.testandroidapplication

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.example.testandroidapplication.databinding.ActivityMainBinding
import com.example.testandroidapplication.ui.PostAlbumsViewModel
import com.example.testandroidapplication.ui.ViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: PostAlbumsViewModel
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.postList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        viewModel = ViewModelProviders.of(this, ViewModelFactory()).get(PostAlbumsViewModel::class.java)
        binding.viewModel = viewModel
    }
}
