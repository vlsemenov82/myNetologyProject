package com.example.mynetologyproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.mynetologyproject.adapter.PostsAdapter
import com.example.mynetologyproject.databinding.ActivityMainBinding
import com.example.mynetologyproject.viewmodel.PostViewModel


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewmodel: PostViewModel by viewModels()

        val adapter = PostsAdapter({
            viewmodel.like(it.id)
        },{
            viewmodel.share(it.id)
        })

        binding.recyclerList.adapter = adapter

        viewmodel.data.observe(this) { posts ->
            adapter.submitList(posts)
        }
    }
}




