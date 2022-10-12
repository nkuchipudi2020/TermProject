package com.example.termproject.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
// TODO: change this to local server now:  http://10.0.2.2:3000/tasks
object ServiceGenerator {
    private val client = OkHttpClient.Builder().build()
    private val retrofit = Retrofit.Builder().baseUrl("http://10.0.2.2:3000/tasks/")
        .addConverterFactory(GsonConverterFactory.create()).client(client).build()

    fun<T> buildService(service : Class<T>):T{
        return retrofit.create(service)
    }

}


/**
 * Need to send a put request to change "done" in tasks in the actual server */
