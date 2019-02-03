package com.francis.mvvm.app

import android.app.Application
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.squareup.otto.Bus
import com.squareup.otto.ThreadEnforcer
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class AppController : Application() {

    internal var repo: Repo? = null
    internal var gson: Gson? = null
    internal var preference: AppPreference? = null
    internal var bus: Bus? = null


    override fun onCreate() {
        super.onCreate()
        controller = this
        preference = AppPreference(this)
        bus = Bus(ThreadEnforcer.ANY)
        gson = GsonBuilder().setLenient().serializeNulls().create()
        repo = createRepo()
    }

    companion object {
        private var controller: AppController? = null
        fun getInstance() = controller
    }


    private fun createRepo(): Repo {

        val loginInterceptor = HttpLoggingInterceptor()
        loginInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient = OkHttpClient.Builder()
            .readTimeout(180, TimeUnit.SECONDS)
            .writeTimeout(180, TimeUnit.SECONDS)
            .connectTimeout(180, TimeUnit.SECONDS)
            .addInterceptor(loginInterceptor)
            .build()

        val retrofit = Retrofit.Builder().baseUrl(ApiConstanct.BASE_URL)
            .client(okHttpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(Gson())).build()

        return Repo(retrofit.create(RepoApi::class.java))


    }
}