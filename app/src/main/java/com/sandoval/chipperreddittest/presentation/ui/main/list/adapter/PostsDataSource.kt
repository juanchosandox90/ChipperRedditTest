package com.sandoval.chipperreddittest.presentation.ui.main.list.adapter

import androidx.paging.PageKeyedDataSource
import com.sandoval.chipperreddittest.model.Post

class PostsDataSource(private val listener: Listener) : PageKeyedDataSource<String, Post>() {
    override fun loadInitial(
        params: LoadInitialParams<String>,
        callback: LoadInitialCallback<String, Post>
    ) {
        listener.onLoadInitial(callback)
    }

    override fun loadAfter(
        params: LoadParams<String>,
        callback: LoadCallback<String, Post>
    ) {
        listener.onLoadAfter(params.key, callback)
    }

    override fun loadBefore(
        params: LoadParams<String>,
        callback: LoadCallback<String, Post>
    ) {
        listener.onLoadBefore(params.key, callback)
    }

    interface Listener {
        fun onLoadInitial(callback: LoadInitialCallback<String, Post>)

        fun onLoadAfter(after: String?, callback: LoadCallback<String, Post>)

        fun onLoadBefore(before: String?, callback: LoadCallback<String, Post>)
    }
}