package com.develop.rubenpla.abatest.app

import android.app.Application
import com.develop.rubenpla.abatest.di.component.AppComponent
import com.develop.rubenpla.abatest.di.component.DaggerAppComponent
import com.develop.rubenpla.abatest.di.module.AppModule

class AbaTestApplication : Application() {

    @Suppress("DEPRECATION")
    companion object {
        val appComponent : AppComponent by lazy {
            DaggerAppComponent
                    .builder()
                    .appModule(AppModule(AbaTestApplication()))
                    .build()
        }

        lateinit var applicationInstance : AbaTestApplication
    }

    override fun onCreate() {
        super.onCreate()
        appComponent.inject(this)
        applicationInstance = this
    }

    fun appComponent() : AppComponent = appComponent
}