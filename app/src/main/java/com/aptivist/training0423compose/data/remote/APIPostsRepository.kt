package com.aptivist.training0423compose.data.remote

import com.aptivist.training0423compose.data.IPostsAPI
import com.aptivist.training0423compose.data.toDomain
import com.aptivist.training0423compose.domain.IPostsRepository
import com.aptivist.training0423compose.domain.models.Posts
import javax.inject.Inject

class APIPostsRepository @Inject constructor(private val postsApi: IPostsAPI) : IPostsRepository {
    override suspend fun getPosts(): List<Posts> {
        val result = postsApi.getPosts()
       return result.body()?.map { it.toDomain() } ?: emptyList()
    }
}