package com.develop.rubenpla.abatest.view.home.view

import com.develop.rubenpla.abatest.view.base.contract.BaseView

interface HomeFragmentView : BaseView {

    fun setCsvDataToRecyclerView(itemList : List<*>)
    fun showLoading()
    fun hideLoading()
}