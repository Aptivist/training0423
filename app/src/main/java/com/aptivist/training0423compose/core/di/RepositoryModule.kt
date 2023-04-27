package com.aptivist.training0423compose.core.di

import com.aptivist.training0423compose.data.IPostsAPI
import com.aptivist.training0423compose.data.remote.APIPostsRepository
import com.aptivist.training0423compose.domain.IPostsRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun providePostsRepository(implementation: APIPostsRepository): IPostsRepository

}