package com.sandoval.chipperreddittest.data.repository

import com.sandoval.chipperreddittest.data.api.RedditApiService
import com.sandoval.chipperreddittest.data.db.PostsDao

class PostsRepositoryImpl constructor(
    private val apiService: RedditApiService,
    private val postsDao: PostsDao
) {

    //TODO: Create in domain the PostsRepository to impl the methods getRemote, getLocals, updateLocals (offline mode here)
}