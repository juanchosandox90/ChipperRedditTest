package com.sandoval.chipperreddittest.data.db

import androidx.room.*
import com.sandoval.chipperreddittest.model.Post

@Dao
interface PostsDao {

    @Query("SELECT * FROM Posts")
    suspend fun getPosts(): List<Post>

    @Transaction
    suspend fun updatePosts(posts: List<Post>) {
        deletePosts()
        insertPosts(posts)
    }

    @Query("DELETE FROM Posts")
    suspend fun deletePosts()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPosts(posts: List<Post>)
}