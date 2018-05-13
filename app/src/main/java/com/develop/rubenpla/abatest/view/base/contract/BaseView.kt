package com.develop.rubenpla.abatest.view.base.contract

import android.content.Context
import android.support.annotation.Nullable
import com.develop.rubenpla.abatest.view.base.presenter.BasePresenter

interface BaseView {

    fun showError(errorMessage : String)
    fun setPresenter(presenter : BasePresenter<*>)
    @Nullable fun provideContext() : Context
}