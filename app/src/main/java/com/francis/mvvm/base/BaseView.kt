package com.francis.mvvm.base

interface BaseView {
    fun showLoading()
    fun hideLoading()
    fun showError(message: String)
}