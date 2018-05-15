package com.develop.rubenpla.abatest.util

object CvsAdapterController {

    fun provideValidImageResource(itemUrlImageResource : String?) : String? {
        var urlToReturn : String?
        val isValidResource = UrlImageFormatController
                .performImageUrlCheckControl(itemUrlImageResource)

        urlToReturn = if (isValidResource) {
            itemUrlImageResource
        } else {
            "https://api.learn2crack.com/android/images/donut.png"
        }

        return urlToReturn
    }
}