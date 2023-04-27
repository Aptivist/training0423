package com.aptivist.training0423compose.domain

import com.aptivist.training0423compose.domain.models.Posts

interface IPostsRepository {
    suspend fun getPosts() : List<Posts>
}