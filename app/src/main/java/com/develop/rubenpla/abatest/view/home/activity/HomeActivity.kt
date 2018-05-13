package com.develop.rubenpla.abatest.view.home.activity

import android.os.Bundle
import com.develop.rubenpla.abatest.R
import com.develop.rubenpla.abatest.view.base.activity.BaseActivity
import com.develop.rubenpla.abatest.view.home.fragment.HomeFragment

class HomeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.home_activity_fragment_container, HomeFragment())
        transaction.commit()
    }
}
