package com.sandoval.chipperreddittest.domain.usecases

import com.sandoval.chipperreddittest.domain.util.Either
import com.sandoval.chipperreddittest.domain.common.BaseUseCase
import com.sandoval.chipperreddittest.domain.repository.PostsRepository
import com.sandoval.chipperreddittest.model.Post
import com.sandoval.chipperreddittest.model.PostContainer
import timber.log.Timber
import java.lang.Exception

class GetInitialPostsUserCase(
    private val repository: PostsRepository
) : BaseUseCase<PostContainer, GetInitialPostsUserCase.Params>() {
    override suspend fun run(params: Params): Either<Throwable, PostContainer> {
        return try {
            val postContainer = repository.getRemotePosts(params.limit)
            updateLocalPosts(postContainer.posts)
            Either.Right(postContainer)
        } catch (t: Throwable) {
            Timber.e(t, "Failed to get remote posts.")
            try {
                val posts = repository.getLocalPost()
                if (posts.isEmpty()) throw Exception("No local posts found.")
                Either.Right(PostContainer(posts))
            } catch (t: Throwable) {
                Either.Left(t)
            }
        }
    }

    private suspend fun updateLocalPosts(posts: List<Post>) {
        try {
            repository.updateLocalPosts(posts)
        } catch (t: Throwable) {
            Timber.e(t, "Failed to update local posts.")
        }
    }

    data class Params(val limit: Int)
}