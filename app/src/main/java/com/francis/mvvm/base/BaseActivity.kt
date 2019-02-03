package com.francis.mvvm.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.francis.mvvm.app.AppController
import com.francis.mvvm.app.AppPreference

open class BaseActivity : AppCompatActivity() {

    var preference: AppPreference? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setInstance()
    }

    private fun setInstance() {
        preference = AppController.getInstance()?.preference
    }
}