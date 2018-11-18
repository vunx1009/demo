package com.vunx1009.demo.networks

import org.json.JSONArray

interface IJsonResponse {
    fun response(value: JSONArray);
}