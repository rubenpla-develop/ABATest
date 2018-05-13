package com.develop.rubenpla.abatest.view.base.contract

import android.content.Context
import com.develop.rubenpla.abatest.view.base.presenter.BasePresenter

interface BaseView {

    fun showError(errorMessage : String)
    fun setPresenter(presenter : BasePresenter<*>)
    fun getContext() : Context
}