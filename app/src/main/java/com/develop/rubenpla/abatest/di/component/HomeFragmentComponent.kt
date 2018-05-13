package com.develop.rubenpla.abatest.di.component

import com.develop.rubenpla.abatest.di.scope.ActivityScope
import com.develop.rubenpla.abatest.di.module.HomeFragmentModule
import com.develop.rubenpla.abatest.view.home.fragment.HomeFragment
import dagger.Component

@ActivityScope
@Component(dependencies = [(AppComponent::class)], modules = [(HomeFragmentModule::class)])
interface HomeFragmentComponent {

    fun inject(homeFragment : HomeFragment)
}