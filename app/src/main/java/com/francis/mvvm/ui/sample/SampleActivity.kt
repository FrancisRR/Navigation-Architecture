package com.francis.mvvm.ui.sample

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import butterknife.ButterKnife
import butterknife.OnClick
import com.francis.mvvm.R
import com.francis.mvvm.base.BaseActivity
import kotlinx.android.synthetic.main.activity_sample.*

class SampleActivity : BaseActivity() {

    private var TAG: String = this::class.java.simpleName
    private var viewModel: SampleViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample)
        ButterKnife.bind(this)
        setUi()
    }


    private fun setUi() {
        setInstance()
        receiveAction()
    }

    private fun setInstance() {
        viewModel = ViewModelProviders.of(this).get(SampleViewModel::class.java)
        viewModel?.setContext(this)
    }


    private fun setAction() {
        viewModel?.fetchApi()
    }

    private fun receiveAction() {
        viewModel?.postDetailsResponse?.observe(this, Observer { respose ->
            if (respose != null) textView.text = "Api success" else textView.text = "Api Fail"
        })
    }


    @OnClick(R.id.button)
    fun onClickEvent(v: View) {
        setAction()
    }


}
