package com.develop.rubenpla.abatest.view.base.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.develop.rubenpla.abatest.app.AbaTestApplication
import com.develop.rubenpla.abatest.di.component.AppComponent
import com.develop.rubenpla.abatest.view.base.contract.BaseView
import com.develop.rubenpla.abatest.view.base.presenter.BasePresenter

abstract class BaseFragment : Fragment(), BaseView {

    private var presenter: BasePresenter<*>? = null
    abstract val layoutResource : Int

    protected abstract fun onFragmentInject()
    abstract fun initializeView()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view : View = inflater.inflate(layoutResource, container, false)
        onFragmentInject()
        initializeView()

        return view
    }

    fun getAppComponent() : AppComponent = AbaTestApplication.appComponent

    override fun setPresenter(presenter: BasePresenter<*>) {
        this.presenter = presenter
    }

    override fun onPause() {
        super.onPause()
        presenter?.onPause()
    }

    override fun onResume() {
        super.onResume()
        presenter?.onResume()
    }

    override fun onDetach() {
        super.onDetach()
        presenter?.detachView()
        presenter = null
    }
}