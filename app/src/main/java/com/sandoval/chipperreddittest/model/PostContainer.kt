package com.sandoval.chipperreddittest.model

data class PostContainer(
    val posts: List<Post>,
    val after: String? = null,
    val before: String? = null
)