package com.sandoval.chipperreddittest.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize
import java.text.DecimalFormat
import java.util.*
import java.util.concurrent.TimeUnit

@Parcelize
@Entity(tableName = "Posts")
data class Post(
    @field:Json(name = "id") @PrimaryKey val id: String,
    @field:Json(name = "title") val title: String,
    @field:Json(name = "author") val author: String,
    @field:Json(name = "subreddit") val subreddit: String,
    @field:Json(name = "score") val score: Int,
    @field:Json(name = "num_comments") val numComments: Int,
    @field:Json(name = "created_utc") val created: Long,
    @field:Json(name = "thumbnail") val thumbnail: String,
    @field:Json(name = "url") val url: String,
    @field:Json(name = "permalink") val permalink: String
) : Parcelable {
    fun getCreatedHoursAgo(): Long {
        val current = TimeUnit.MILLISECONDS.toSeconds(Calendar.getInstance().timeInMillis)
        val secondsAgo = current - created
        return TimeUnit.SECONDS.toHours(secondsAgo)
    }

    fun getScoreFormatted() = score.toFormattedString()

    fun getNumCommentsFormatted() = numComments.toFormattedString()

    private fun Int.toFormattedString(): String = if (this >= 1000) {
        val format = DecimalFormat("0.#")
        "${format.format(this / 1000f)}k"
    } else {
        this.toString()
    }
}