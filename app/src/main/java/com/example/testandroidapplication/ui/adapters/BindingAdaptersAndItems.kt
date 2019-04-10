package com.example.testandroidapplication.ui.adapters

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.databinding.BindingAdapter
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso


@BindingAdapter("mutableTitle")
fun setMutableName(view : TextView, text : MutableLiveData<String>?){
    val parentAvtivity : AppCompatActivity? = view.getParentActivity()
    if(parentAvtivity!=null&&text!=null){
        text.observe(parentAvtivity, Observer { value -> view.text = value?:"" })
    }
}


@BindingAdapter("thumbnailUrl", "picasso")
fun setThumbnailUrl(view: ImageView, thumbnailUrl : String, picasso: Picasso) {
    Picasso.get()
        .load(thumbnailUrl)
        .into(view);}