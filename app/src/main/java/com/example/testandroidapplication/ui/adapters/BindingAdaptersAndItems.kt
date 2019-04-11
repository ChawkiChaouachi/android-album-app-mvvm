package com.example.testandroidapplication.ui.adapters

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.databinding.BindingAdapter
import android.databinding.ObservableField
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso


@BindingAdapter("android:customVisibility")
fun setVisibility(view: View, visible: ObservableField<Boolean>) {
    view.visibility = if (visible.get()==false) View.INVISIBLE else View.VISIBLE
}


@BindingAdapter("adapter")
fun setAdapter(view: RecyclerView, adapter: RecyclerView.Adapter<*>) {
    view.adapter = adapter
}

@BindingAdapter("mutableTitle")
fun setMutableName(view: TextView, text: MutableLiveData<String>?) {
    val parentAvtivity: AppCompatActivity? = view.getParentActivity()
    if (parentAvtivity != null && text != null) {
        text.observe(parentAvtivity, Observer { value -> view.text = value ?: "" })
    }
}

@BindingAdapter("observableTxt")
fun setObservableTxt(view : TextView,obj : ObservableField<String>){
 val parentActivity : AppCompatActivity? = view.getParentActivity()
    if(parentActivity!=null && obj.get()!=null)
        view.text = obj.get() ?: ""
}

@BindingAdapter("thumbnailUrl")
fun setThumbnailUrl(view: ImageView, thumbnailUrl: MutableLiveData<String>?) {
    val parentAvtivity: AppCompatActivity? = view.getParentActivity()
    if (parentAvtivity != null && thumbnailUrl != null) {
        thumbnailUrl.observe(parentAvtivity, Observer { value ->
            Picasso.get()
                .load(value)
                .into(view);
        })
    }




}
