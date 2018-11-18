package com.vunx1009.demo.networks

import android.content.Context
import android.support.annotation.WorkerThread
import com.vunx1009.demo.utils.readFile
import org.json.JSONArray
import org.json.JSONException

/**
 * This class load simulated data from asset directory instead of network.
 * the request will run on background thread.
 */
class NetworkRequester (private val context: Context, private val url: String, private val response: IJsonResponse, private val error: IError) : INetworkRequest {

    @WorkerThread
    override fun request() {
        Thread(Runnable {
            try {
                Thread.sleep(1000)

                val jsData = JSONArray(context.assets.readFile("keywords.json"));
                response.response(jsData);
            } catch (e: JSONException) {
                e.printStackTrace()
                error.error("Can not parse data!")
            }
        }).start()
    }
}