package com.slowhand.kt

import android.app.Application
import com.slowhand.kt.di.KoinModule
import org.koin.android.ext.android.startKoin

class RootApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(KoinModule.module()))
    }
}