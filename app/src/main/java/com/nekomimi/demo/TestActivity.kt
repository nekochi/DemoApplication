package com.nekomimi.demo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.nekomim.core.BaseActivity
import com.nekomim.core.download.DownloadManager
import com.nekomim.core.download.DownloadManagerImpl
import com.nekomim.core.net.RetrofitBuilder
import com.nekomim.core.net.providerRetrofit
import com.nekomimi.demo.api.FFlogsService
import com.nekomimi.demo.databinding.ActivityTestBinding

/**
 * Created by Nekomimi on 2020/7/29.
 */
class TestActivity : BaseActivity(){
    private lateinit var _bind : ActivityTestBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _bind = ActivityTestBinding.inflate(layoutInflater)
        setContentView(_bind.root)

        var service = providerRetrofit(object : RetrofitBuilder{
            override var baseUrl: String = "https://www.fflogs.com:443/"
        }).create(FFlogsService::class.java)
        service.requestReports().subscribe({
            Log.d("tag", "yes")
        },{
            it.printStackTrace()
        })

    }
}