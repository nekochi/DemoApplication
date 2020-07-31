package com.nekomim.core.net

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.reflect.KProperty


/**
 * Created by Nekomimi on 2020/7/27.
 */

fun providerRetrofit(builder: RetrofitBuilder) : Retrofit{
    val client = OkHttpClient.Builder().apply {
        builder.interceptors()?.forEach {
            this.addInterceptor(it)
        }
    }.build()
    return  Retrofit.Builder().client(client)
        .baseUrl(builder.baseUrl).apply {
            if(builder.isGson()) addConverterFactory(GsonConverterFactory.create())
            if(builder.isRxJavaSupport()) addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        }
        .build()
}

interface RetrofitBuilder{

    var baseUrl : String

    fun isGson() : Boolean{
        return true
    }

    fun isRxJavaSupport() : Boolean {
        return true
    }

    fun interceptors() : List<Interceptor>?{
        return null
    }
}

