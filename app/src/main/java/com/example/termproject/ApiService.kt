package com.example.termproject

import com.example.termproject.models.PostModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.PUT

interface ApiService {
    @GET("/posts")
    fun getPosts() : Call<MutableList<PostModel>>

    @PUT("/posts")
    fun putRequest() : Call<MutableList<PostModel>>


}