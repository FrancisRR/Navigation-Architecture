package com.francis.mvvm.ui.sample

import android.annotation.SuppressLint
import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.francis.mvvm.base.BaseViewModel
import com.francis.mvvm.data.response.postdetails.PostDetailsResponse
import com.francis.mvvm.utils.RxJavaUtils

class SampleViewModel() : BaseViewModel() {

    private var TAG = this::class.java.simpleName
    internal var postDetailsResponse: MutableLiveData<PostDetailsResponse>? = null
    private var context: Context? = null

    internal fun setContext(mainActivity: Context) {
        this.context = mainActivity

    }

    init {
        postDetailsResponse = MutableLiveData()

    }

    @SuppressLint("CheckResult")
    fun fetchApi() {
        showLoading(context, "")
        repo?.postDetails()
            ?.compose(RxJavaUtils.applyObserverbleScheduler())
            ?.subscribe({ response ->
                postDetailsResponse?.value = response
                hideLoading()
            }, { thowable ->
                postDetailsResponse?.value = null
                hideLoading()
                exceptionHandling(thowable)
            })
    }


}