package com.nekomimi.demo.api

import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

/**
 * Created by Nekomimi on 2020/7/29.
 */

interface FFlogsService {

    @GET("v1/zones?api_key=dc1bc353085850dbf491715ddd70f51c")
    fun requestReports() : Observable<Zone>
}