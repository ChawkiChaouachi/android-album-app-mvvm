package com.example.testandroidapplication.injection.component

import com.example.testandroidapplication.injection.module.NetworkModule
import com.example.testandroidapplication.ui.PostAlbumsViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(NetworkModule::class)])
interface InjectorViewModel {

    fun inject(postViewModel: PostAlbumsViewModel)

    @Component.Builder
    interface Builder {
        fun build(): InjectorViewModel

        fun networkModule(networkModule: NetworkModule): Builder
    }
}