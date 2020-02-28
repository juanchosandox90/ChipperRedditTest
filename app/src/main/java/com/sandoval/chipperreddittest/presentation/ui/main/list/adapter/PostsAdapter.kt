package com.sandoval.chipperreddittest.presentation.ui.main.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sandoval.chipperreddittest.R
import com.sandoval.chipperreddittest.databinding.ItemPostsBinding
import com.sandoval.chipperreddittest.model.Post
import com.sandoval.chipperreddittest.presentation.util.extension.onClick

class PostsAdapter(private val onItemClick: (Post) -> Unit) :
    PagedListAdapter<Post, PostsAdapter.PostsViewHolder>(PostsDiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
        return PostsViewHolder(parent)
    }

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it, onItemClick) }
    }

    class PostsViewHolder(
        private val parent: ViewGroup,
        private val binding: ItemPostsBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_posts,
            parent,
            false
        )
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Post, onItemClick: (Post) -> Unit) {
            binding.posts = item
            binding.root.onClick { onItemClick(item) }
        }
    }
}