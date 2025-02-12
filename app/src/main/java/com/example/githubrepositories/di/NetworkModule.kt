package com.example.githubrepositories.di

import com.example.githubrepositories.data.Constants.Companion.BASE_URL
import com.example.githubrepositories.data.datasources.remote.retrofit.api.GithubAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// creating a retrofit instance,
// we will use dependency injection later
class NetworkModule {
    companion object {
        fun provideRetrofitInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        // we create it in separate function because if we have too much interfaces
        // will can use the same instance for this
        fun provideGithubApi(retrofit: Retrofit): GithubAPI {
            return retrofit.create(GithubAPI::class.java)
        }

    }
}