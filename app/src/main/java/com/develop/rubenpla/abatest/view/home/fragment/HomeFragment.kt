package com.develop.rubenpla.abatest.view.home.fragment

import android.content.Context
import android.view.View
import android.widget.Toast
import com.develop.rubenpla.abatest.R
import com.develop.rubenpla.abatest.di.component.DaggerHomeFragmentComponent
import com.develop.rubenpla.abatest.di.module.HomeFragmentModule
import com.develop.rubenpla.abatest.view.base.fragment.BaseFragment
import com.develop.rubenpla.abatest.view.home.presenter.HomeFragmentPresenter
import com.develop.rubenpla.abatest.view.home.view.HomeFragmentView
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject

class HomeFragment : BaseFragment(), HomeFragmentView {

    @Inject
    lateinit var presenter : HomeFragmentPresenter

    @Suppress("DEPRECATION")
    override fun onFragmentInject() {
        DaggerHomeFragmentComponent.builder().appComponent(getAppComponent())
                .homeFragmentModule(HomeFragmentModule())
                .build()
                .inject(this)

        presenter.attachView(this)
    }

    override val layoutResource: Int
        get() = R.layout.fragment_home

    override fun provideContext(): Context {
        return super.getContext()!!
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.terminate()
    }

    override fun initializeView() {
        presenter.loadDataFromCsv()
    }

    override fun showError(errorMessage: String) {
        Toast.makeText(activity, errorMessage, Toast.LENGTH_LONG).show()
    }

    override fun setCsvDataToRecyclerView(itemList: List<*>) {

    }

    override fun showLoading() {
        homeLoading.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        homeLoading.visibility = View.GONE
    }

}