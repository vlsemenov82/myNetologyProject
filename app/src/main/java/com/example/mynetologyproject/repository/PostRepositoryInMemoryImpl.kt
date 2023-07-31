package com.example.mynetologyproject.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mynetologyproject.dto.Post

class PostRepositoryInMemoryImpl : PostRepository {

    private var posts = listOf(
        Post(
            id = 1,
            author = "Нетология. Университет интернет-профессий будущего",
            content = "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. " +
                    "Затем появились курсы по дизайну, разработке, аналитике и управлению. Мы растём сами и помогаем расти студентам: " +
                    "от новичков до уверенных профессионалов. Но самое важное остаётся с нами: мы верим, что в каждом уже есть сила, " +
                    "которая заставляет хотеть больше, целиться выше, бежать быстрее. Наша миссия — помочь встать на путь роста и начать " +
                    "цепочку перемен → http://netolo.gy/fyb",
            published = "21 мая в 18:36",
            likedByMe = false,
            likesCount = 999,
            shareCount = 999,
            visibilityCount = 0
        ),
        Post(
            id = 2,
            author = "Нетология. Университет интернет-профессий будущего",
            content = "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. " +
                    "Затем появились курсы по дизайну, разработке, аналитике и управлению. Мы растём сами и помогаем расти студентам: " +
                    "от новичков до уверенных профессионалов. Но самое важное остаётся с нами: мы верим, что в каждом уже есть сила, " +
                    "которая заставляет хотеть больше, целиться выше, бежать быстрее. Наша миссия — помочь встать на путь роста и начать " +
                    "цепочку перемен → http://netolo.gy/fyb",
            published = "21 мая в 18:46",
            likedByMe = false,
            likesCount = 15,
            shareCount = 15,
            visibilityCount = 0
        ),
        Post(
            id = 3,
            author = "Нетология. Университет интернет-профессий будущего",
            content = "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. " +
                    "Затем появились курсы по дизайну, разработке, аналитике и управлению. Мы растём сами и помогаем расти студентам: " +
                    "от новичков до уверенных профессионалов. Но самое важное остаётся с нами: мы верим, что в каждом уже есть сила, " +
                    "которая заставляет хотеть больше, целиться выше, бежать быстрее. Наша миссия — помочь встать на путь роста и начать " +
                    "цепочку перемен → http://netolo.gy/fyb",
            published = "21 мая в 18:56",
            likedByMe = false,
            likesCount = 99,
            shareCount = 99,
            visibilityCount = 0
        ),
        Post(
            id = 4,
            author = "Нетология. Университет интернет-профессий будущего",
            content = "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. " +
                    "Затем появились курсы по дизайну, разработке, аналитике и управлению. Мы растём сами и помогаем расти студентам: " +
                    "от новичков до уверенных профессионалов. Но самое важное остаётся с нами: мы верим, что в каждом уже есть сила, " +
                    "которая заставляет хотеть больше, целиться выше, бежать быстрее. Наша миссия — помочь встать на путь роста и начать " +
                    "цепочку перемен → http://netolo.gy/fyb",
            published = "21 мая в 19:06",
            likedByMe = false,
            likesCount = 9999,
            shareCount = 9999,
            visibilityCount = 0
        ),
    )

    private val data = MutableLiveData(posts)

    override fun get(): LiveData<List<Post>> = data

    override fun like(id: Long) {
        posts = posts.map {
            if(it.id !=id) it else it.copy(likedByMe = !it.likedByMe, likesCount = if (it.likedByMe) it.likesCount - 1 else it.likesCount + 1)
        }
        data.value = posts
    }

    override fun share(id: Long) {
        posts = posts.map {
            if(it.id !=id) it else it.copy(shareCount = it.shareCount + 1)
        }
        data.value = posts
    }

}