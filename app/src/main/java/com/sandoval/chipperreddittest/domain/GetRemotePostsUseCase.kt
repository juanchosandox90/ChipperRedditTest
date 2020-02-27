package com.sandoval.chipperreddittest.domain

import com.sandoval.chipperreddittest.model.PostContainer

class GetRemotePostsUseCase(
    private val repository: PostsRepository
) : BaseUseCase<PostContainer, GetRemotePostsUseCase.Params>() {

    override suspend fun run(params: Params): Either<Throwable, PostContainer> {
        return try {
            val posts = repository.getRemotePosts(params.limit, params.after, params.before)
            Either.Right(posts)
        } catch (t: Throwable) {
            Either.Left(t)
        }
    }

    data class Params(val limit: Int, val after: String? = null, val before: String? = null)
}