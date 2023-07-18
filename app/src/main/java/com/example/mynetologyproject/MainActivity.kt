package com.example.mynetologyproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mynetologyproject.databinding.ActivityMainBinding
import com.example.mynetologyproject.dto.Post
import kotlin.math.floor

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val post = Post(
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
            shareCount = 0,
            visibilityCount = 0
        )

        with(binding) {
            author.text = post.author
            published.text = post.published
            content.text = post.content
            if (post.likedByMe) {
                likes.setImageResource(R.drawable.baseline_favorite_24)
            }
            likesNumber.text = likesCount(post.likesCount)
            sharedNumber.text = post.shareCount.toString()
            visibilityNumber.text = post.visibilityCount.toString()

            likes.setOnClickListener {
                post.likedByMe = !post.likedByMe
                if (post.likedByMe) post.likesCount++ else post.likesCount--
                likes.setImageResource(if (post.likedByMe) R.drawable.baseline_favorite_24 else R.drawable.ic_baseline_favorite_border_24)
                likesNumber.text = likesCount(post.likesCount)
            }

            share.setOnClickListener {
                post.shareCount++
                sharedNumber.text = post.shareCount.toString()
            }
        }
    }

    private fun likesCount(count: Long): String {
        if (count >= 1100000) { return (floor(count / 100000 * 10.0) / 100.0).toString() + "M" }
        if (count >= 1000000) { return "1M" }
        if (count >= 1100) { return (count / 1000).toString() + "К" }
        if (count >= 1000) { return "1К" }
        return count.toString()
    }
}

