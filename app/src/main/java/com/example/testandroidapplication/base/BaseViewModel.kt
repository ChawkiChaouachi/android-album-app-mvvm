package com.example.testandroidapplication.base

import android.arch.lifecycle.ViewModel
import com.example.testandroidapplication.MyApplication
import com.example.testandroidapplication.injection.component.DaggerInjectorViewModel
import com.example.testandroidapplication.injection.component.InjectorViewModel
import com.example.testandroidapplication.injection.module.DaoModule
import com.example.testandroidapplication.injection.module.NetworkModule
import com.example.testandroidapplication.ui.PostAlbumsViewModel


abstract class BaseViewModel : ViewModel(){

    private val injectorViewModel : InjectorViewModel = DaggerInjectorViewModel.builder().networkModule(NetworkModule).daoModule(DaoModule(
        MyApplication.getContext())).build()

    init {
        inject()
    }


    private fun inject() {
        when(this){
            is PostAlbumsViewModel ->injectorViewModel.inject(this)
        }
    }
}