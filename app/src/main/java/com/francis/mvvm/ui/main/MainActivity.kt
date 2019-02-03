package com.francis.mvvm.ui.main

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.francis.mvvm.R

class MainActivity : AppCompatActivity() {

    internal var mainListener: MainListener? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
    }

    internal fun setListener(mainListener: MainListener?) {
        this.mainListener = mainListener;
    }

    override fun onBackPressed() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment)
        val backStackSize: Int? = navHostFragment?.childFragmentManager?.fragments?.size
        Log.e("MAIN", "" + backStackSize)

        mainListener?.onBackPressed()
    }

    override fun onRestart() {
        super.onRestart()
    }

    internal fun finishMainActivity() {
        finish()
    }

}
