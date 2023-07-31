package com.example.mynetologyproject.viewmodel

import androidx.lifecycle.ViewModel
import com.example.mynetologyproject.repository.PostRepository
import com.example.mynetologyproject.repository.PostRepositoryInMemoryImpl

class PostViewModel: ViewModel() {

    private val repository: PostRepository = PostRepositoryInMemoryImpl()

    val data = repository.get()

    fun like() = repository.like()

    fun share() = repository.share()

}