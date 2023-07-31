package com.example.mynetologyproject.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mynetologyproject.R
import com.example.mynetologyproject.databinding.PostCardLayoutBinding
import com.example.mynetologyproject.dto.Post
import kotlin.math.floor

typealias OnLikeListener = (post: Post) -> Unit
typealias OnShareListener = (post: Post) -> Unit

class PostsAdapter(
    private val onLikeListener: OnLikeListener,
    private val onShareListener: OnShareListener
) :
    ListAdapter<Post, PostViewHolder>(PostDiffCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding =
            PostCardLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(binding, onLikeListener, onShareListener)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = getItem(position)
        holder.bind(post)
    }
}


class PostViewHolder(
    private val binding: PostCardLayoutBinding,
    private val onLikeListener: OnLikeListener,
    private val onShareListener: OnShareListener


) : RecyclerView.ViewHolder(binding.root) {
    fun bind(post: Post) {
        binding.apply {
            author.text = post.author
            published.text = post.published
            content.text = post.content
            likesNumber.text = likesCount(post.likesCount)
            sharedNumber.text = likesCount(post.shareCount)
            visibilityNumber.text = post.visibilityCount.toString()
            likes.setImageResource(if (post.likedByMe) R.drawable.baseline_favorite_24 else R.drawable.ic_baseline_favorite_border_24)
            likes.setOnClickListener {
                onLikeListener(post)
            }
            share.setOnClickListener {
                onShareListener(post)
            }
        }
    }

    private fun likesCount(count: Long): String {
        if (count >= 1100000) {
            return (floor(count / 100000 * 10.0) / 100.0).toString() + "M"
        }
        if (count >= 1000000) {
            return "1M"
        }
        if (count >= 1100) {
            return (count / 1000).toString() + "К"
        }
        if (count >= 1000) {
            return "1К"
        }
        return count.toString()
    }
}


class PostDiffCallback : DiffUtil.ItemCallback<Post>() {
    override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
        return oldItem == newItem
    }

}

