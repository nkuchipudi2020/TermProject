package com.example.termproject.network

import com.example.termproject.ApiService
import com.example.termproject.models.Property
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.PUT
// TODO: To start local server, use command json-server --watch data.json
// TODO: change this to local server now:  http://10.0.2.2:3000/tasks
//private const val BASE_URL = "https://my-json-server.typicode.com/nkuchipudi2020/termDB/db/posts"
//private const val BASE_URL = "http://10.0.2.2:3000/"
//
//private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
//private val retrofit = Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create(moshi)).baseUrl(BASE_URL).build()



//interface ApiService{
//    @GET("/tasks")
//    fun getAllData(): Call<List<Property>>
//
//}

//object Api{
//    val retrofitService: ApiService by lazy{retrofit.create(ApiService::class.java)}
//}