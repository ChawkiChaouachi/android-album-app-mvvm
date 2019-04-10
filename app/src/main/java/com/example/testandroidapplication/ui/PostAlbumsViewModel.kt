package com.example.testandroidapplication.ui

import android.databinding.ObservableField
import android.util.Log
import com.example.testandroidapplication.base.BaseViewModel
import com.example.testandroidapplication.injection.repo.AlbumRepository
import com.example.testandroidapplication.model.Album
import com.example.testandroidapplication.network.NetworkService
import com.example.testandroidapplication.ui.adapters.AdapterAlbumsRecycler
import com.google.gson.Gson
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PostAlbumsViewModel : BaseViewModel() {
    @Inject
    lateinit var networkService: NetworkService

    @Inject
    lateinit var albumRepository: AlbumRepository

    private lateinit var subscription: Disposable
    val gson = Gson()
    var adapterAlbumsRecycler: AdapterAlbumsRecycler = AdapterAlbumsRecycler();
    var progressBarState = ObservableField<Boolean>()

    init {
        loadAllAlbums()
    }


    private fun loadAllAlbums() {
        progressBarState.set(true)
        Log.d("PostAlbumsViewModel ", "begin")
        subscription = Observable.fromCallable { albumRepository.findAllAlbum() }
            .concatMap { dbPostList ->
                Log.d("PostAlbumsViewModel ", "is empty list")
                if (dbPostList == null || dbPostList.isEmpty()) {
                    Log.d("PostAlbumsViewModel ", "is empty list")
                    networkService.getAlbumList().concatMap { apiPostList ->
                        albumRepository.insert(apiPostList)
                        Observable.just(apiPostList)
                    }
                } else {
                    Observable.just(dbPostList)
                }
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { }
            .doOnTerminate { }
            .subscribe(

                { result ->

                    onRetrievePostListSuccess(result as List<Album>)

                    progressBarState.set(false)
                },
                {   progressBarState.set(false)}
            )

    }

    private fun onRetrievePostListSuccess(postList: List<Album>) {
        adapterAlbumsRecycler.updateChanged(postList)
    }

}