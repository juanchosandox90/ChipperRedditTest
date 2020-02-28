package com.sandoval.chipperreddittest.presentation.di

import android.content.Context
import androidx.room.Room
import com.sandoval.chipperreddittest.data.db.RedditDatabase

internal fun createDatabase(context: Context) =
    Room.databaseBuilder(context, RedditDatabase::class.java, DATABASE_NAME)
        .build()

private const val DATABASE_NAME = "posts.db"