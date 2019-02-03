package com.francis.mvvm.app

import com.francis.mvvm.data.response.postdetails.PostDetailsResponse
import com.francis.mvvm.utils.RxJavaUtils
import io.reactivex.Observable

class Repo(val repoApi: RepoApi) {

    var preference: AppPreference? = null

    init {
        preference = AppController.getInstance()?.preference
    }


    public fun postDetails(): Observable<PostDetailsResponse> {
        return repoApi.getPostDetails()
            .compose(RxJavaUtils.applyErrorTransformer())
            .map { it }
    }


}