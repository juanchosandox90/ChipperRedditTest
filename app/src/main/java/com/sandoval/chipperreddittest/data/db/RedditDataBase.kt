package com.sandoval.chipperreddittest.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sandoval.chipperreddittest.model.Post

@Database(entities = [Post::class], version = 1, exportSchema = false)
abstract class RedditDatabase : RoomDatabase() {
    abstract fun getPostsDao(): PostsDao
}