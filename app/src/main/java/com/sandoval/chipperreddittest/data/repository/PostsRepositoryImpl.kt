package com.sandoval.chipperreddittest.data.repository

import com.sandoval.chipperreddittest.data.api.RedditApiService
import com.sandoval.chipperreddittest.data.db.PostsDao
import com.sandoval.chipperreddittest.domain.repository.PostsRepository
import com.sandoval.chipperreddittest.model.Post
import com.sandoval.chipperreddittest.model.PostContainer

class PostsRepositoryImpl constructor(
    private val apiService: RedditApiService,
    private val postsDao: PostsDao
) : PostsRepository {
    override suspend fun getLocalPost(): List<Post> = postsDao.getPosts()

    override suspend fun updateLocalPosts(post: List<Post>) = postsDao.updatePosts(post)

    override suspend fun getRemotePosts(
        limit: Int,
        after: String?,
        before: String?
    ): PostContainer {
        val apiData = apiService.getTop(limit, after, before).listingData
        return PostContainer(
            posts = apiData.children.map { it.post },
            after = apiData.after,
            before = apiData.before
        )
    }

}