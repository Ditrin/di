package com.example.spacexlist.di

import android.content.Context
import com.example.spacexlist.domain.Interactor
import dagger.Module
import dagger.Provides


@Module
class AppModule() {

    @Provides
    fun provideViewModelFactory(interactor: Interactor): ViewModelFactory{
        return ViewModelFactory(interactor = interactor)
    }

}