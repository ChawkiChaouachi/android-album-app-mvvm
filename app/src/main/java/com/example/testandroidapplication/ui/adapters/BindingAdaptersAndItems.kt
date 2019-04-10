package com.example.testandroidapplication.ui.adapters

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.databinding.BindingAdapter
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

@BindingAdapter("adapter")
fun setAdapter(view : RecyclerView, adapter : RecyclerView.Adapter<*>){
    view.adapter =adapter
}
@BindingAdapter("mutableTitle")
fun setMutableName(view : TextView, text : MutableLiveData<String>?){
    val parentAvtivity : AppCompatActivity? = view.getParentActivity()
    if(parentAvtivity!=null&&text!=null){
        text.observe(parentAvtivity, Observer { value -> view.text = value?:"" })
    }
}


@BindingAdapter("thumbnailUrl")
fun setThumbnailUrl(view: ImageView, thumbnailUrl : MutableLiveData<String>?) {
    val parentAvtivity : AppCompatActivity? = view.getParentActivity()
    if(parentAvtivity!=null&&thumbnailUrl!=null){
        thumbnailUrl.observe(parentAvtivity, Observer { value ->   Picasso.get()
            .load(value)
            .into(view); })
    }
}
