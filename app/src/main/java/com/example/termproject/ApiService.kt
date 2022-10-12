package com.example.termproject

import com.example.termproject.models.PostModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.PUT

interface ApiService {
    @GET("/tasks")
    fun getPosts() : Call<MutableList<PostModel>>

//    @PUT("/tasks")
//    fun putRequest() : Call<MutableList<PostModel>>


}