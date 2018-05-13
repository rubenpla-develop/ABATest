package com.develop.rubenpla.abatest.view.base.presenter

import com.develop.rubenpla.abatest.view.base.contract.BaseView
import com.develop.rubenpla.abatest.view.base.contract.PresenterContract

class BasePresenter<T : BaseView> : PresenterContract<T>  {
    override fun attachView(view: T) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun detachView() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onResume() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onPause() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}