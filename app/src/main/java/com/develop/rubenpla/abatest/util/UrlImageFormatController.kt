package com.develop.rubenpla.abatest.util

import android.util.Patterns
import java.net.URL

object UrlImageFormatController {

    fun performImageUrlCheckControl(url : String?) : Boolean {

        return (isUrlValidFormat(url) )
    }

    private fun isUrlValidFormat(url : String?) : Boolean {
        return Patterns.WEB_URL.matcher(url).matches()
    }

    private fun isUrlValidImageResource(url : String?) : Boolean {
        val connection = URL(url).openConnection()
        val contentType = connection.getHeaderField("Content-Type")

        return  contentType.startsWith("image/")
    }

}