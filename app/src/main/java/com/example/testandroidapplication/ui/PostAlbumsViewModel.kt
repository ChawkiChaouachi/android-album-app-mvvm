package com.example.testandroidapplication.ui

import android.util.Log
import com.example.testandroidapplication.base.BaseViewModel
import com.example.testandroidapplication.model.Album
import com.example.testandroidapplication.network.NetworkService
import com.google.gson.Gson
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PostAlbumsViewModel : BaseViewModel() {
    @Inject
    lateinit var networkService : NetworkService
    private lateinit var subscription : Disposable
    val gson = Gson()
    init {
        loadAllAlbums()
    }

    private fun loadAllAlbums() {
        Log.d("PostListNumbersModel","begin work hello")
        subscription = Observable.fromCallable { networkService.getAlbumList() }.concatMap {
                listAlbums ->
            Observable.just(listAlbums)
        }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { }
            .doOnTerminate { }
            .subscribe(
                { result ->
                    if(result!=null )
                    Log.d("PostListNumbersModel","list ready "+gson.toJson(result.blockingFirst()))},
                {

                        error->                       Log.d("PostListNumbersModel",error.localizedMessage)

                }
            )
    }


}