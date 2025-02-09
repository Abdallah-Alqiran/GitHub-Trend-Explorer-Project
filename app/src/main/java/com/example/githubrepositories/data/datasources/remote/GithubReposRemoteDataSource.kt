package com.example.githubrepositories.data.datasources.remote

import android.util.Log
import com.example.githubrepositories.data.datasources.remote.retrofit.api.GithubAPI
import com.example.githubrepositories.data.datasources.remote.retrofit.model.GithubReposDataModel
import com.example.githubrepositories.di.NetworkModule

class GithubReposRemoteDataSource(
    private val githubAPI: GithubAPI = NetworkModule
        .provideGithubApi(
            NetworkModule.provideRetrofitInstance()
        )
) {
    fun fetchGithubRepos(): GithubReposDataModel {
        return try {
            githubAPI.fetchGithubRepoData().body() as GithubReposDataModel
        } catch (e: Exception) {
            Log.d("githubException", "Error Loading the data")
            throw e
        }
    }
}