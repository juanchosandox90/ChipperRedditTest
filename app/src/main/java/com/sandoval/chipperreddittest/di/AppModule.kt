package com.sandoval.chipperreddittest.di

import com.sandoval.chipperreddittest.data.api.RedditApiService
import com.sandoval.chipperreddittest.data.repository.PostsRepositoryImpl
import com.sandoval.chipperreddittest.domain.repository.PostsRepository
import com.sandoval.chipperreddittest.domain.usecases.GetInitialPostsUserCase
import com.sandoval.chipperreddittest.domain.usecases.GetRemotePostsUseCase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

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
        createDatabase(androidApplication()).getPostDao()
    }
}

//TODO: Create viewModelModules after ViewModel implementation in the future