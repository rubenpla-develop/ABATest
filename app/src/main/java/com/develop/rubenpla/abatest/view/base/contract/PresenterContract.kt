package com.develop.rubenpla.abatest.view.base.contract

interface PresenterContract<in T : BaseView> {

    fun attachView(view : T)
    fun detachView()
    fun onResume()
    fun onPause()
}