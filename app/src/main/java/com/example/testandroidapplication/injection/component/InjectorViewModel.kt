package com.example.testandroidapplication.injection.component

import com.example.testandroidapplication.injection.module.NetworkModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(NetworkModule::class)])
interface InjectorViewModel {

    @Component.Builder
    interface Builder {
        fun build(): InjectorViewModel

        fun networkModule(networkModule: NetworkModule): Builder
    }
}