package com.nekomim.core.download

/**
 * Created by Nekomimi on 2020/7/31.
 */
class DownloadTask {

    var downloadId : Int = 0
    lateinit var name : String
    lateinit var downloadUrl : String
    lateinit var fileName : String
    lateinit var path : String
    var progress : Int = 0
    lateinit var state: DownloadState
}


class RealDownloadTask(val downloadTask: DownloadTask){

    init {

    }

}

enum class DownloadState{
    Waiting,
    Downloading,
    Pause,
    Error,
    Finish

}