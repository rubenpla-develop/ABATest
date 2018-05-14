package com.develop.rubenpla.abatest.api

import retrofit2.http.GET

interface CsvResourceService {

    @GET("u/0/d/1cOAfpXY7nuc-Llo5UJl0UI-st5UOUgLqCQEfGoTSxco/export?format=csv")
    fun getCsv(): String?
}