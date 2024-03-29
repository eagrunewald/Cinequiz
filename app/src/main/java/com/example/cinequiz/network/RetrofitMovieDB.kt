package com.example.cinequiz.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.reflect.KClass

private val gsonConverter: GsonConverterFactory = GsonConverterFactory.create()

class RetrofitMovieDB (url : String){

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(url)
        .client(OkHttpClient.Builder().apply { addInterceptor(ApiKeyInterceptor()) }.build())
        .addConverterFactory(gsonConverter)
        .build()

    fun <T : Any> create(clazz: KClass<T>): T = retrofit.create(clazz.java)
}