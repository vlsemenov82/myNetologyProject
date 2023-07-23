package com.example.mynetologyproject.dto

data class Post(
    val id: Long,
    val author: String,
    val content: String,
    val published: String,
    val likedByMe: Boolean = false,
    val likesCount: Long,
    val shareCount: Long,
    val visibilityCount: Long
)
