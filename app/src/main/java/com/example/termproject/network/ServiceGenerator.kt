package com.example.termproject.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceGenerator {
    private val client = OkHttpClient.Builder().build()
    private val retrofit = Retrofit.Builder().baseUrl("https://my-json-server.typicode.com/nkuchipudi2020/termDB/")
        .addConverterFactory(GsonConverterFactory.create()).client(client).build()

    fun<T> buildService(service : Class<T>):T{
        return retrofit.create(service)
    }

}