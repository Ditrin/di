package com.example.spacexlist.di

import com.example.spacexlist.MainActivity
import com.example.spacexlist.presentation.HistoricalEventsFragment
import dagger.Component

@Component(modules = [AppModule:: class, DomainModule::class, DataModule::class])
interface AppComponent { //объект, который занимается внедрением зависимостей

    fun inject(activity: MainActivity)

    fun inject(fragment: HistoricalEventsFragment)
}