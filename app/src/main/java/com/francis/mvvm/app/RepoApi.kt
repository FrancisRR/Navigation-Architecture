package com.francis.mvvm.app

import com.francis.mvvm.data.response.postdetails.PostDetailsResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface RepoApi {


    @GET(ApiConstanct.POST_DETAILS)
    fun getPostDetails(): Observable<PostDetailsResponse>

}