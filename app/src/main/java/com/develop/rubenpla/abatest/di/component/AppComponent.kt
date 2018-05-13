package com.develop.rubenpla.abatest.di.component

import com.develop.rubenpla.abatest.app.AbaTestApplication
import com.develop.rubenpla.abatest.di.module.AppModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(AppModule::class)])
interface AppComponent {

    fun inject(app : AbaTestApplication)
}