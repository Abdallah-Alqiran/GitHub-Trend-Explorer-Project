package com.example.githubrepositories.di

import com.example.githubrepositories.data.repository.GithubRepositoryImp
import com.example.githubrepositories.domain.repository.GithubReposRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun provideRepositoryModuleImp(
        githubReposRepositoryImp: GithubRepositoryImp
    ): GithubReposRepository
}