package com.francis.mvvm.utils

import io.reactivex.CompletableTransformer
import io.reactivex.Observable
import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

object RxJavaUtils {

    fun <T> applyObserverbleScheduler(): ObservableTransformer<T, T> {
        return ObservableTransformer { upstream ->
            upstream.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
        }
    }


    fun <T> applyErrorTransformer(): ObservableTransformer<T, T> {
        return ObservableTransformer { upstream ->
            upstream.onErrorResumeNext(Function { throwable ->
                try {
                    if (throwable is ConnectException || throwable is UnknownHostException) {
                        if (NetworkUtils.isNetworkAvailable()) {
                            Observable.error(RuntimeException("Unknow host exception"))
                        } else {
                            Observable.error(RuntimeException("Network Exception"))
                        }
                    } else if (throwable is SocketTimeoutException) {
                        Observable.error(RuntimeException("Slow intenet connection"))
                    } else {
                        Observable.error(RuntimeException(throwable.message))
                    }
                } catch (e: Exception) {
                    Observable.error(throwable)
                }
            })

        }
    }


    fun <T> applyNewObservableScheduler(): ObservableTransformer<T, T> {
        return ObservableTransformer { observable -> observable.subscribeOn(Schedulers.newThread()) }
    }

    fun applyCompletableSchedulers(): CompletableTransformer {
        return CompletableTransformer { upstream ->
            upstream.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
        }
    }
}