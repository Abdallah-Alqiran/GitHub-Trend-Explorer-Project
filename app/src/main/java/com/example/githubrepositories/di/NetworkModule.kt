package com.example.githubrepositories.di

import com.example.githubrepositories.data.Constants.Companion.BASE_URL
import com.example.githubrepositories.data.datasources.remote.retrofit.api.GithubAPI
import com.example.githubrepositories.data.datasources.remote.retrofit.api.RepoDetailsApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

// creating a retrofit instance,
// we will use dependency injection later

@Module
@InstallIn(SingletonComponent::class) // make it's scope in the whole app
object NetworkModule {

    @Provides // providing instance from retrofit
    @Singleton // make it as a singleton to create just one time
    fun provideRetrofitInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // we create it in separate function because if we have too much interfaces
    // will can use the same instance for this
    @Provides // provide instance from GithubAPI
    @Singleton // make it as a singleton to create just one time
    fun provideGithubApi(retrofit: Retrofit): GithubAPI {
        return retrofit.create(GithubAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideRepoDetailsApi(retrofit: Retrofit): RepoDetailsApi {
        return retrofit.create(RepoDetailsApi::class.java)
    }


}