package com.vunx1009.demo.models

import android.R
import android.content.Context
import android.util.Log
import com.vunx1009.demo.interfaces.ISearchKeyListener
import com.vunx1009.demo.interfaces.ISearchModel
import com.vunx1009.demo.networks.IError
import com.vunx1009.demo.networks.IJsonResponse
import com.vunx1009.demo.networks.NetworkBuilder
import com.vunx1009.demo.objects.Keyword
import com.vunx1009.demo.utils.KeywordUtil
import org.json.JSONArray
import java.util.function.Consumer

class SearchModel (val context: Context): ISearchModel {
    override fun getKeywords(result: ISearchKeyListener) {
        NetworkBuilder.get(context, "")
            .setErrorListener(object : IError {
                override fun error(message: String) {
                    result.key(null)
                }
            })
            .getAsJsonObject(object : IJsonResponse {
                override fun response(data: JSONArray) {
                    result.key(parseToKeyword(data))
                }
            })
            .build()
            .request()
    }

    private fun parseToKeyword(jsData: JSONArray) : List<Keyword>{
        val keywords = ArrayList<Keyword>()
        for (i in 0..(jsData.length() - 1)) {
            val item = jsData.getString(i);
            keywords.add(Keyword(item, KeywordUtil.randomColor()))
        }
        return keywords;
    }
}