package com.sandoval.chipperreddittest.presentation.ui.main.list.adapter

import androidx.recyclerview.widget.DiffUtil
import com.sandoval.chipperreddittest.model.Post

class PostsDiffCallBack : DiffUtil.ItemCallback<Post>() {
    override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
        return oldItem.title == newItem.title
                && oldItem.score == newItem.score
                && oldItem.numComments == newItem.numComments
    }
}