package com.vunx1009.demo.networks

import android.content.Context
import com.vunx1009.demo.utils.readFile
import org.json.JSONArray
import org.json.JSONException

/**
 * The class will load the list of keyword.
 */
class NetworkRequester (private val context: Context, private val url: String, private val response: IJsonResponse, private val error: IError) : INetworkRequest{

    override fun request() {
        try {
            val jsData = JSONArray(context.assets.readFile("keywords.json"));
            response.response(jsData);
        } catch (e : JSONException) {
            e.printStackTrace()
            error.error("Can not parse data!")
        }

    }
}