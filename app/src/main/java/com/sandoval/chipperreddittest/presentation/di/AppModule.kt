package com.sandoval.chipperreddittest.presentation.di

import com.sandoval.chipperreddittest.data.api.RedditApiService
import com.sandoval.chipperreddittest.data.repository.PostsRepositoryImpl
import com.sandoval.chipperreddittest.domain.repository.PostsRepository
import com.sandoval.chipperreddittest.domain.usecases.GetInitialPostsUserCase
import com.sandoval.chipperreddittest.domain.usecases.GetRemotePostsUseCase
import org.koin.android.ext.koin.androidApplication
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import com.sandoval.chipperreddittest.presentation.ui.main.list.PostsViewModel

val useCaseModules = module {
    factory {
        GetRemotePostsUseCase(repository = get())
    }

    factory {
        GetInitialPostsUserCase(repository = get())
    }
}

val repositoryModules = module {
    single<PostsRepository> {
        PostsRepositoryImpl(apiService = get(), postsDao = get())
    }
}

val networkModules = module {
    single {
        createNetworkClient().create(RedditApiService::class.java)
    }
}

val localModules = module {
    single {
        createDatabase(androidApplication()).getPostsDao()
    }
}

val viewModelModules = module {
    viewModel {
        PostsViewModel(getInitialPostsUseCase = get(), getRemotePostsUseCase = get())
    }
}