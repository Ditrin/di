package com.example.spacexlist

import android.app.Application
import android.content.Context
import com.example.spacexlist.di.AppComponent
import com.example.spacexlist.di.DaggerAppComponent

class App: Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()

    }
}

val Context.appComponent: AppComponent
    get() = when (this) {
        is MainActivity -> appComponent
        else -> applicationContext.appComponent
    }