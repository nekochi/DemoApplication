package com.nekomim.core.download

import io.reactivex.rxjava3.core.Observable

/**
 * Created by Nekomimi on 2020/7/31.
 */

interface DownloadManager{

    fun addDownload(url : String) : Observable<Any>
}