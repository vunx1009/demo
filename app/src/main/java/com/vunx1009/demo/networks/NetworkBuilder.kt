package com.vunx1009.demo.networks

import android.content.Context
import android.support.annotation.VisibleForTesting
import org.json.JSONArray

/**
 * The builder class that support building NetworkRequest class
 */
class NetworkBuilder (val context: Context,val url: String) {
    private var response: IJsonResponse;
    private var error : IError;

    init {
        response = object : IJsonResponse {
            override fun response(value: JSONArray) {
            }
        }

        error  = object : IError {
            override fun error(message: String) {
            }
        }
    }

    companion object {
        fun get(context: Context, url: String): NetworkBuilder {
            return NetworkBuilder(context, url);
        }
    }

    fun getAsJsonObject(listener: IJsonResponse): NetworkBuilder {
        response = listener;
        return this;
    }

    fun setErrorListener(listener: IError): NetworkBuilder {
        error = listener
        return this;
    }

    fun build() : INetworkRequest {
        return NetworkRequester(context, url, response, error);
    }
}