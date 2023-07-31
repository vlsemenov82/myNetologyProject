package com.example.mynetologyproject.repository

import androidx.lifecycle.LiveData
import com.example.mynetologyproject.dto.Post

interface PostRepository {
    fun get(): LiveData<Post>
    fun like()
    fun share()
}