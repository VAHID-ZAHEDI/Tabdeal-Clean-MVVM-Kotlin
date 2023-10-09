package com.example.tabdeal

import android.app.Application
import android.content.Context
import android.view.LayoutInflater
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class AppConfig :Application() {

    override fun onCreate() {
        super.onCreate()
        application=this
    }

    companion object {
        lateinit var application: Application

        fun getMyApplicationContext(): Context {
            return application.applicationContext
        }
    }
}