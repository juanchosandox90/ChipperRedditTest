package com.sandoval.chipperreddittest.domain.repository

import com.sandoval.chipperreddittest.model.Post
import com.sandoval.chipperreddittest.model.PostContainer

interface PostsRepository {
    suspend fun getLocalPost(): List<Post>

    suspend fun updateLocalPosts(post: List<Post>)

    suspend fun getRemotePosts(
        limit: Int,
        after: String? = null,
        before: String? = null
    ): PostContainer
}