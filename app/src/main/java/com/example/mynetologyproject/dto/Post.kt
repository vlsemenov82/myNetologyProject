package com.example.mynetologyproject.dto

data class Post(
    val id: Int,
    val author: String,
    val content: String,
    val published: String,
    var likedByMe: Boolean = false,
    var likesCount: Long,
    var shareCount: Int,
    var visibilityCount: Int
)
