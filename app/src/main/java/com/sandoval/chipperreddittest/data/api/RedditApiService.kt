package com.sandoval.chipperreddittest.data.api

import com.sandoval.chipperreddittest.model.Post
import com.squareup.moshi.Json
import retrofit2.http.GET
import retrofit2.http.Query

interface RedditApiService {

    @GET("/top.json")
    suspend fun getTop(
        @Query("limit") limit: Int,
        @Query("after") after: String? = null,
        @Query("before") before: String? = null
    ): ListingResponse

    data class ListingResponse(
        @field:Json(name = "data") val listingData: ListingData
    )

    data class ListingData(
        @field:Json(name = "children") val children: List<ChildrenResponse>,
        @field:Json(name = "after") val after: String?,
        @field:Json(name = "before") val before: String?
    )

    data class ChildrenResponse(
        @field:Json(name = "data") val post: Post
    )
}