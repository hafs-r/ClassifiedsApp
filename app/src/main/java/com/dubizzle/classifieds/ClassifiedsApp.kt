package com.dubizzle.classifieds

import android.app.Application
import com.dubizzle.classifieds.di.appModule
import com.dubizzle.classifieds.di.networkModule
import org.koin.android.ext.android.startKoin

class ClassifiedsApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(networkModule, appModule))
    }
}