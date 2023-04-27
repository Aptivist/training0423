package com.aptivist.training0423compose.data

import com.aptivist.training0423compose.data.models.PostDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface IPostsAPI {
    @GET("/posts")
    suspend fun getPosts():Response<PostDTO>
}