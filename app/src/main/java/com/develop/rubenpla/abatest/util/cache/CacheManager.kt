package com.develop.rubenpla.abatest.util.cache

import com.develop.rubenpla.abatest.app.AbaTestApplication
import com.develop.rubenpla.abatest.common.AppConstants
import com.develop.rubenpla.abatest.common.AppConstants.CACHE_CSV_FILENAME
import java.io.File

object CacheManager {

    fun writeToCache(content : String?) {
        checkIfExistsCacheFile()

        val cacheFile = File(AbaTestApplication.applicationInstance.cacheDir,
                AppConstants.CACHE_CSV_FILENAME)

        if (content != null) {
            cacheFile.writeText(content)
        }
    }

    fun readFromCacheFile() : String? {
        var cachedContentToReturn : String
        checkIfExistsCacheFile()

        val cacheFile = File(AbaTestApplication.applicationInstance.cacheDir,
                AppConstants.CACHE_CSV_FILENAME)

        cachedContentToReturn = if (!cacheFile.exists() ||cacheFile.readText().isEmpty()) {
            ""
        } else {
            cacheFile.readText()
        }

        return cachedContentToReturn
    }

    private fun checkIfExistsCacheFile() {
        val cacheFile = File(AbaTestApplication.applicationInstance.cacheDir,
                AppConstants.CACHE_CSV_FILENAME)

        if (!cacheFile.exists()) {
            generateCacheFile()
        }
    }

    private fun generateCacheFile() {
        File.createTempFile(CACHE_CSV_FILENAME, null,
                AbaTestApplication.applicationInstance.cacheDir)
    }
}