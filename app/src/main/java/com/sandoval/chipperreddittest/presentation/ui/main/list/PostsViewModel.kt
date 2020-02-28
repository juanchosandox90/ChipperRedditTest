package com.sandoval.chipperreddittest.presentation.ui.main.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PageKeyedDataSource.LoadCallback
import androidx.paging.PageKeyedDataSource.LoadInitialCallback
import androidx.paging.PagedList
import com.sandoval.chipperreddittest.domain.usecases.GetInitialPostsUserCase
import com.sandoval.chipperreddittest.domain.usecases.GetRemotePostsUseCase
import com.sandoval.chipperreddittest.model.Post
import com.sandoval.chipperreddittest.model.PostContainer
import com.sandoval.chipperreddittest.presentation.common.BaseViewModel
import com.sandoval.chipperreddittest.presentation.ui.main.list.PostsViewModel.ListState.*
import com.sandoval.chipperreddittest.presentation.ui.main.list.adapter.PostsDataSource
import timber.log.Timber

class PostsViewModel(
    private val getInitialPostsUseCase: GetInitialPostsUserCase,
    private val getRemotePostsUseCase: GetRemotePostsUseCase
) : BaseViewModel(), PostsDataSource.Listener {
    val stateLiveData = MutableLiveData<ListState>()

    val postsLiveData: LiveData<PagedList<Post>> by lazy {
        val config = PagedList.Config.Builder()
            .setPageSize(PAGE_SIZE)
            .setEnablePlaceholders(false)
            .build()
        initPagedListBuilder(config).build()
    }

    fun refresh(onRefreshed: () -> Unit) {
        postsLiveData.value?.dataSource?.apply {
            addInvalidatedCallback(onRefreshed::invoke)
            invalidate()
        }
    }

    override fun onLoadInitial(callback: LoadInitialCallback<String, Post>) {
        updateState(INITIAL_LOADING)
        getInitialPosts {
            callback.onResult(it.posts, it.before, it.after)
            updateState(LOADED)
        }
    }

    override fun onLoadAfter(after: String?, callback: LoadCallback<String, Post>) {
        getRemotePosts(
            after = after,
            onSuccess = { callback.onResult(it.posts, it.after) }
        )
    }

    override fun onLoadBefore(before: String?, callback: LoadCallback<String, Post>) {
        getRemotePosts(
            before = before,
            onSuccess = { callback.onResult(it.posts, it.after) }
        )
    }

    private fun getInitialPosts(onSuccess: (PostContainer) -> Unit) {
        val params = GetInitialPostsUserCase.Params(PAGE_SIZE)
        getInitialPostsUseCase.invoke(viewModelScope, params) {
            it.either(this::initialLoadError, onSuccess)
        }
    }

    private fun getRemotePosts(
        after: String? = null,
        before: String? = null,
        onSuccess: (PostContainer) -> Unit = {}
    ) {
        val params = GetRemotePostsUseCase.Params(PAGE_SIZE, after, before)
        getRemotePostsUseCase.invoke(viewModelScope, params) { it.either(Timber::e, onSuccess) }
    }

    private fun updateState(state: ListState) = stateLiveData.postValue(state)

    private fun initPagedListBuilder(config: PagedList.Config): LivePagedListBuilder<String, Post> {
        val dataSourceFactory = object : DataSource.Factory<String, Post>() {
            override fun create() = PostsDataSource(this@PostsViewModel)
        }
        return LivePagedListBuilder(dataSourceFactory, config)
    }

    private fun initialLoadError(t: Throwable) {
        Timber.e(t, "Failed to get remote and local posts.")
        updateState(EMPTY)
    }

    enum class ListState {
        INITIAL_LOADING,
        LOADED,
        EMPTY
    }

    private companion object {
        const val PAGE_SIZE = 25
    }
}