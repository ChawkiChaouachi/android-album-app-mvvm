package com.example.testandroidapplication.ui

import android.databinding.ObservableField
import android.util.Log
import android.view.View
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
    var layoutErrorState = ObservableField<Boolean>()
    var textViewvalueListner = ObservableField<String>()
    init {
        loadAllAlbums()
    }


    private fun loadAllAlbums() {
        OnFetchData()
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
                { error-> OnDataErrorLoaded(error.localizedMessage) }
            )

    }

    private fun onRetrievePostListSuccess(postList: List<Album>) {
        adapterAlbumsRecycler.updateChanged(postList)
    }

    private fun OnFetchData(){
        progressBarState.set(true)
        layoutErrorState.set(false)
    }

    private fun OnDataErrorLoaded(error : String){
        progressBarState.set(false)
        layoutErrorState.set(true)
        if(error!=null)
            textViewvalueListner.set(error)
        else
            textViewvalueListner.set("Please retry")
    }

    fun OnRetryClick(v : View){
        loadAllAlbums()
    }

}