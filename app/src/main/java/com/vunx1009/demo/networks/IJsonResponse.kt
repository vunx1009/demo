package com.vunx1009.demo.networks

import org.json.JSONArray

/**
 * This interface will emitted when data load successfully.
 */
interface IJsonResponse {
    fun response(value: JSONArray);
}