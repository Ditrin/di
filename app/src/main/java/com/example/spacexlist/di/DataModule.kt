package com.example.spacexlist.di

import com.example.spacexlist.data.repository.SpaceXDataRepositoryImpl
import com.example.spacexlist.domain.EventMapper
import com.example.spacexlist.domain.Interactor
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {

    @Provides
    fun provideSpaceXDataRepository(): SpaceXDataRepositoryImpl {
        return SpaceXDataRepositoryImpl()
    }

}