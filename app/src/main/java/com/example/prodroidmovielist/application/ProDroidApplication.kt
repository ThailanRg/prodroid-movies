package com.example.prodroidmovielist.application

import android.app.Application
import com.example.prodroidmovielist.feature.list.di.loginModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class ProDroidApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidLogger()
            androidContext(this@ProDroidApplication)
            modules(loginModule)
        }
    }
}