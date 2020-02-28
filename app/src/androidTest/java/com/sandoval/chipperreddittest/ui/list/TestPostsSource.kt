package com.sandoval.chipperreddittest.ui.list

import com.sandoval.chipperreddittest.model.Post
import com.sandoval.chipperreddittest.model.PostContainer

internal fun getTestPostsContainer(n: Int): PostContainer {
    val list = arrayListOf<Post>()
    for (i in 0..n) {
        list.add(
            Post(
                title = "Test Post $i",
                id = "test$i",
                author = "test_author",
                subreddit = "test_sub",
                score = 165608,
                numComments = 2264,
                created = 1567339200,
                thumbnail = "https://b.thumbs.redditmedia.com/asm-6dIoRqX95zM3aBU_SZHqPReS2QyzCeuLJRohe7g.jpg",
                url = "https://i.redd.it/jlx9wokn7tl31.jpg",
                permalink = "/r/funny/comments/d2bwot/printers/"
            )
        )
    }
    return PostContainer(list)
}