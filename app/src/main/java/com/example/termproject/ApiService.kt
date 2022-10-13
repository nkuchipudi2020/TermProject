package com.example.termproject

import com.example.termproject.models.PostModel
import retrofit2.Call
import retrofit2.http.*


interface ApiService {
    @GET("/posts")
    fun getPosts() : Call<MutableList<PostModel>>

    @FormUrlEncoded
    @PUT("/posts/{id}")
    fun putRequest(
        @Path("id") id: Int?,
        @Field("task") task: String?,
        @Field("done") done: Boolean?
        ) : Call<PostModel>


}