package com.aptivist.training0423compose.core.di

import android.content.Context
import com.aptivist.training0423compose.data.local.PersonRepository
import com.aptivist.training0423compose.domain.IPersonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NameModule {

    @Provides
    @Singleton
    fun providePerson(@ApplicationContext context: Context) : IPersonRepository {
        return PersonRepository()
    }

}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class Name

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class Surname