package com.example.rubenpla.csvreadertest

import com.develop.rubenpla.abatest.app.AbaTestApplication
import com.develop.rubenpla.abatest.common.AppConstants.BASE_URL
import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

interface CsvApi {

    @GET("u/0/d/1cOAfpXY7nuc-Llo5UJl0UI-st5UOUgLqCQEfGoTSxco/export?format=csv")
    fun getCsv(): Flowable<String?>

    companion object Factory {

        fun getInstance(): CsvApi {
            val retrofit = retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory
                            .createWithScheduler(Schedulers.io()))
                    .client(createOkHttpClient())
                    .build()

            return retrofit.create(CsvApi::class.java)
        }

        private fun createOkHttpClient() : OkHttpClient {
            val cacheSize = 10 * 1024 * 1024 // 10 MB
            val cache = Cache(AbaTestApplication.applicationInstance.cacheDir, cacheSize.toLong())

            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY

            val okHttpClient = OkHttpClient.Builder()

            okHttpClient.addInterceptor(logging)
            okHttpClient.cache(cache)

            return okHttpClient.build()
        }
    }
}