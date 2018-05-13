package com.develop.rubenpla.abatest.di.module

import com.develop.rubenpla.abatest.di.scope.ActivityScope
import com.develop.rubenpla.abatest.view.home.presenter.HomeFragmentPresenter
import dagger.Module
import dagger.Provides

@Module
class HomeFragmentPresenterModule {

    @Provides
    @ActivityScope
    fun providesHomeFragmentPresenter() : HomeFragmentPresenter {
        return HomeFragmentPresenter()
    }
}