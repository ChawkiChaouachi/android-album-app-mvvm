package com.example.testandroidapplication.base

import android.arch.lifecycle.ViewModel




abstract class BaseViewModel : ViewModel(){

    init {
        inject()
    }

    private fun inject() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}