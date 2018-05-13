package com.develop.rubenpla.abatest.view.base.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.develop.rubenpla.abatest.app.AbaTestApplication
import com.develop.rubenpla.abatest.di.component.AppComponent

abstract class BaseFragment : Fragment() {

    abstract val layoutResource : Int

    protected abstract fun onFragmentInject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view : View = inflater.inflate(layoutResource, container, false)
        onFragmentInject()
        return view
    }

    fun getAppComponent() : AppComponent = AbaTestApplication.appComponent
}