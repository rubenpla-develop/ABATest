package com.example.rubenpla.csvreadertest

import io.reactivex.Flowable

class CsvRepository(private val apiService : CsvApi?) {

    fun getCsv() : Flowable<String?>? {
         return apiService?.getCsv()
    }
}