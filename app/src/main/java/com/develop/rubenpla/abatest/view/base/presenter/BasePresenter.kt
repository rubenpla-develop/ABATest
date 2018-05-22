package com.develop.rubenpla.abatest.view.base.presenter

import com.develop.rubenpla.abatest.view.base.contract.BaseView
import com.develop.rubenpla.abatest.view.base.contract.PresenterContract
import java.lang.ref.WeakReference

abstract class BasePresenter<T : BaseView> : PresenterContract<T>  {

    private var isInForeground : Boolean = false
    private var weakReference : WeakReference<T>? = null

    val view : T?
        get() = weakReference?.get()

    private val isViewAttached : Boolean
        get() = weakReference != null && weakReference!!.get() != null

    abstract fun terminate()

    override fun attachView(view: T) {
        if (!isViewAttached) {
            weakReference = WeakReference(view)
            view.setPresenter(this)
        }
    }

    override fun detachView() {
        weakReference?.clear()
        weakReference = null
    }

    override fun onResume() {
        isInForeground = true
    }

    override fun onPause() {
        isInForeground = false
    }
}