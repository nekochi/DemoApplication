package com.nekomim.core.download

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.internal.operators.observable.ObservableFromIterable
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.concurrent.Executor
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.ThreadPoolExecutor

/**
 * Created by Nekomimi on 2020/7/31.
 */
object DownloadManagerImpl : DownloadManager by DownloadHelper(){

    const val maxDownloadingCount = 3


    private var downloadingList : MutableList<DownloadTask> = mutableListOf()
    private var downloadTaskMap : MutableMap<String,DownloadTask> = mutableMapOf()

    private val downloadThreadPool : ExecutorService by lazy {
        Executors.newFixedThreadPool(5)
    }


    private class DownloadHelper : DownloadManager{
        override fun addDownload(url: String): Observable<Any> {

            return Observable.just(null)
        }



        private fun newDownloadTask(url : String){

        }

    }
}


