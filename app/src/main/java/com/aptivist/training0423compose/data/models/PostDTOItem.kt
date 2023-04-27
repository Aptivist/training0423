package com.aptivist.training0423compose.data.models

import com.google.gson.annotations.SerializedName

data class PostDTOItem(
    @SerializedName("body")
    val body: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("userId")
    val userId: Int
)