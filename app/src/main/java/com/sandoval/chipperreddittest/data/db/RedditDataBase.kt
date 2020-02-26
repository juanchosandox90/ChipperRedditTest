package com.sandoval.chipperreddittest.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sandoval.chipperreddittest.model.Post

@Database(entities = [Post::class], version = 1, exportSchema = false)
abstract class RedditDataBase : RoomDatabase() {
    abstract fun getPostDao(): PostsDao
}