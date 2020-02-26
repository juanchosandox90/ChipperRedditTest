package com.sandoval.chipperreddittest.data

class PostsRepositoryImpl constructor(
    private val apiService: RedditApiService,
    private val postsDao: PostsDao
) {

    //TODO: Create in domain the PostsRepository to impl the methods getRemote, getLocals, updateLocals (offline mode here)
}