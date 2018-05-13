package com.develop.rubenpla.abatest.di.module

import com.develop.rubenpla.abatest.app.AbaTestApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val app : AbaTestApplication) {

    @Provides
    @Singleton
    fun provideApp() = app
}