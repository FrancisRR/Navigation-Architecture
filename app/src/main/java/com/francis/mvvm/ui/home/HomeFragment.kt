package com.francis.mvvm.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.francis.mvvm.R
import com.francis.mvvm.base.BaseFragment
import com.francis.mvvm.ui.main.MainListener
import com.francis.mvvm.ui.splash.HomeViewModel
import com.francis.mvvm.utils.UiUtils
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : BaseFragment(), MainListener {

    private var TAG: String = this::class.java.simpleName
    private lateinit var viewModel: HomeViewModel
    private lateinit var mContext: Context

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUi()
    }


    private fun setUi() {
        setInstance()
        setAction()
    }

    private fun setAction() {
        tvHome.setOnClickListener {
            it.findNavController().navigate(R.id.profileLandingFragment)
        }
    }

    private fun setInstance() {
        mContext = context!!
        mainActivity?.setListener(this)
        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
    }

    override fun onBackPressed() {
        onBackPressedBase()
        UiUtils.showToast(mContext, "Back press " + TAG)
    }


}
