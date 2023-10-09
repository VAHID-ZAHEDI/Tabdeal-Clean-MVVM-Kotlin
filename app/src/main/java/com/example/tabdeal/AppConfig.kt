package com.example.tabdeal

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp
import io.github.inflationx.calligraphy3.CalligraphyConfig
import io.github.inflationx.calligraphy3.CalligraphyInterceptor
import io.github.inflationx.viewpump.ViewPump

@HiltAndroidApp
class AppConfig :Application() {

    override fun onCreate() {
        super.onCreate()
        application=this

        ViewPump.init(
            ViewPump.builder()
                .addInterceptor(
                    CalligraphyInterceptor(
                        CalligraphyConfig.Builder()
                            .setDefaultFontPath("fonts/IRANSans(FaNum)_Medium.ttf")
                            .setFontAttrId(io.github.inflationx.calligraphy3.R.attr.fontPath)
                            .build()
                    )
                )
                .build()
        )
    }

    companion object {
        lateinit var application: Application

        fun getMyApplicationContext(): Context {
            return application.applicationContext
        }
    }
}