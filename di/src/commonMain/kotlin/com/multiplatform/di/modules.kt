package com.multiplatform.di

import com.multiplatform.data.NetworkClient
import com.multiplatform.data.NetworkClientFactory
import com.multiplatform.data.services.ArticleService
import com.multiplatform.domain.GetArticlesUc
import com.multiplatform.domain.repository.remotesource.ArticleRemoteSource
import com.multiplatform.domain.repository.repository.ArticleRepository

import org.koin.dsl.module

private val remoteModule = module {
    single<NetworkClient> { NetworkClientFactory.networkClient }
    single<ArticleService> { ArticleService(get()) }

}

val domainModule = module {
   includes(remoteModule)

    single { ArticleRemoteSource(get()) }

    single<ArticleRepository> {
        ArticleRepository(get())
    }

    factory<GetArticlesUc> {
        GetArticlesUc(get())
    }
}