package com.develop.rubenpla.abatest.api

import io.reactivex.Flowable

class CsvRepository(private val apiService : CsvApi?) {

    fun getCsv() : Flowable<String?>? {
         return apiService?.getCsv()
    }
}