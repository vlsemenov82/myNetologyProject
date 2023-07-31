package com.example.mynetologyproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.mynetologyproject.databinding.ActivityMainBinding
import com.example.mynetologyproject.dto.Post
import com.example.mynetologyproject.viewmodel.PostViewModel
import kotlin.math.floor

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewmodel by viewModels<PostViewModel>()

        viewmodel.data.observe(this) {post ->
            with(binding) {
                author.text = post.author
                published.text = post.published
                content.text = post.content
                likesNumber.text = likesCount(post.likesCount)
                sharedNumber.text = likesCount(post.shareCount)
                visibilityNumber.text = post.visibilityCount.toString()
                likes.setImageResource(if (post.likedByMe) R.drawable.baseline_favorite_24 else R.drawable.ic_baseline_favorite_border_24)
            }
        }

        binding.likes.setOnClickListener {
            viewmodel.like()
        }

        binding.share.setOnClickListener {
            viewmodel.share()
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

