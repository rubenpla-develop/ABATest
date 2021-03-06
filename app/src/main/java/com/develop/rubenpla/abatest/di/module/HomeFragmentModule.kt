package com.develop.rubenpla.abatest.di.module

import com.develop.rubenpla.abatest.di.scope.ActivityScope
import com.develop.rubenpla.abatest.view.home.presenter.HomeFragmentPresenter
import dagger.Module
import dagger.Provides

@Module
class HomeFragmentModule {

    @Provides
    @ActivityScope
    internal fun providesHomeFragmentPresenter() : HomeFragmentPresenter {
        return HomeFragmentPresenter()
    }



}