package com.francis.mvvm.data.response.postdetails

import com.google.gson.annotations.SerializedName

data class PostDetailsResponse(

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("title")
    val title: String? = null,

    @field:SerializedName("completed")
    val completed: Boolean? = false,

    @field:SerializedName("userId")
    val userId: Int? = null
)