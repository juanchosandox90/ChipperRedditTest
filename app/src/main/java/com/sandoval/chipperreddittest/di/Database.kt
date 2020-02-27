package com.sandoval.chipperreddittest.di

import android.content.Context
import androidx.room.Room
import com.sandoval.chipperreddittest.data.db.RedditDataBase

private const val DATABASE_NAME = "posts.db"

internal fun createDatabase(context: Context) =
    Room.databaseBuilder(context, RedditDataBase::class.java, DATABASE_NAME).build()