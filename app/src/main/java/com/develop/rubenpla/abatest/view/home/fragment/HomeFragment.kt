package com.develop.rubenpla.abatest.view.home.fragment

import com.develop.rubenpla.abatest.R
import com.develop.rubenpla.abatest.di.component.DaggerHomeFragmentComponent
import com.develop.rubenpla.abatest.di.module.HomeFragmentModule
import com.develop.rubenpla.abatest.view.base.fragment.BaseFragment

class HomeFragment : BaseFragment() {
    @Suppress("DEPRECATION")
    override fun onFragmentInject() {
        DaggerHomeFragmentComponent.builder().appComponent(getAppComponent())
                .homeFragmentModule(HomeFragmentModule())
                .build()
                .inject(this)
    }

    override val layoutResource: Int
        get() = R.layout.fragment_home
}