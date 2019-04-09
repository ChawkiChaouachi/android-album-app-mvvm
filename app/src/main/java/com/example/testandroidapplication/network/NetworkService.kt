package com.example.testandroidapplication.network
import com.example.testandroidapplication.model.Album
import io.reactivex.Observable
import retrofit2.http.GET

interface NetworkService {

    @GET("/img/shared/technical-test.json")
    fun getAlbumList() : Observable<List<Album>>
    
}