package com.example.tabdeal

import android.app.Application
import android.content.Context
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatDelegate
import androidx.multidex.MultiDexApplication
import dagger.hilt.android.HiltAndroidApp
import io.github.inflationx.calligraphy3.CalligraphyConfig
import io.github.inflationx.calligraphy3.CalligraphyInterceptor
import com.example.tabdeal.R
import io.github.inflationx.viewpump.ViewPump

@HiltAndroidApp
class AppConfig :MultiDexApplication() {
    override fun attachBaseContext(base: Context?) {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        super.attachBaseContext(base)



    }
    override fun onCreate() {
        super.onCreate()
        application=this
        inflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
        ViewPump.init(
            ViewPump.builder()
                .addInterceptor(
                    CalligraphyInterceptor(
                        CalligraphyConfig.Builder()
                            .setDefaultFontPath("fonts/IRANSans(FaNum)_Medium.ttf")
                            .setFontAttrId(R.attr.fontPath)

                            .build()
                    )
                )
                .build()
        )
    }

    companion object {
        lateinit var application: Application
        var inflater: LayoutInflater? = null

        fun getMyApplicationContext(): Context {
            return application.applicationContext
        }
    }
}