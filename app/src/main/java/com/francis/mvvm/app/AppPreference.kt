package com.francis.mvvm.app

import android.content.Context
import android.content.SharedPreferences

open class AppPreference(context: Context) {

    private var sharedPreferences: SharedPreferences? = null

    init {
        sharedPreferences =
            context.applicationContext.getSharedPreferences("MY_DB", Context.MODE_PRIVATE)

    }


    private val NAME: String = "NAME_KEY"


    var name: String?
        get() = sharedPreferences?.getString(NAME, "")
        set(value) = sharedPreferences?.edit()?.putString(NAME, value)!!.apply()


}