package com.example.testandroidapplication.injection.module

import com.example.testandroidapplication.network.NetworkService
import com.example.testandroidapplication.utils.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.Reusable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
object NetworkModule {

    @Provides
    @Reusable
    @JvmStatic
    fun provideNetworkInterface(retrofit: Retrofit): NetworkService {
        return retrofit.create(NetworkService::class.java)

    }

    @Provides
    @Reusable
    @JvmStatic
    fun provideClientRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .build()
    }
}