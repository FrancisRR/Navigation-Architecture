package com.francis.mvvm.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.francis.mvvm.ui.main.MainActivity

open class BaseFragment : Fragment() {

    public var mainActivity: MainActivity? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUi()
    }

    private fun setUi() {
        setInstance()
    }

    private fun setInstance() {
        mainActivity = activity as MainActivity
    }


    public fun onBackPressedBase() {
        fragmentManager!!.popBackStack()
    }


}