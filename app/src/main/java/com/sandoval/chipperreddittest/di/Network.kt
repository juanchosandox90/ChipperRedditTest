package com.sandoval.chipperreddittest.di

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import timber.log.Timber
import java.util.concurrent.TimeUnit

private const val BASE_URL = "https://www.reddit.com/"

private fun httpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
    OkHttpClient.Builder()
        .connectTimeout(5L, TimeUnit.SECONDS)
        .readTimeout(15L, TimeUnit.SECONDS)
        .writeTimeout(15L, TimeUnit.SECONDS)
        .addInterceptor(loggingInterceptor)
        .build()

private fun retrofitClient(httpClient: OkHttpClient): Retrofit =
    Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(httpClient)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

private fun logginInterceptor(): HttpLoggingInterceptor {
    val loggin = HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
        override fun log(message: String) {
            Timber.tag("OkHttp").d(message)
        }
    })
    loggin.level = HttpLoggingInterceptor.Level.BASIC
    return loggin
}

internal fun createNetworkClient() = retrofitClient(httpClient(logginInterceptor()))