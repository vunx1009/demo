package com.vunx1009.demo.utils

import android.content.res.AssetManager
import java.nio.charset.Charset
import java.util.*

fun AssetManager.readFile(filename: String): String {
  return open(filename).bufferedReader(Charset.forName("utf-8")).use { it.readText() }
}
