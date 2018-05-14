package com.example.rubenpla.csvreadertest

import com.develop.rubenpla.abatest.common.AppConstants.BASE_URL
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

interface CsvApi {

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
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY

            val okHttpClient = OkHttpClient.Builder()

            okHttpClient.addInterceptor(logging)

            return okHttpClient.build()
        }
    }
}