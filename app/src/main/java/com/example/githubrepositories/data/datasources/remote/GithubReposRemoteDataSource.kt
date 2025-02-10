package com.example.githubrepositories.data.datasources.remote

import android.util.Log
import com.example.githubrepositories.data.datasources.remote.retrofit.api.GithubAPI
import com.example.githubrepositories.data.datasources.remote.retrofit.model.GithubReposDataModel
import com.example.githubrepositories.di.NetworkModule

// this remote repo will deal with retrofit
// (go back to recommended app architecture)
// we will take instance from retrofit
class GithubReposRemoteDataSource(
    private val githubAPI: GithubAPI = NetworkModule
        .provideGithubApi(
            NetworkModule.provideRetrofitInstance()
        )
) {
    // this function will return the data if there is no errors
    fun fetchGithubRepos(): GithubReposDataModel {
        return try {
            githubAPI.fetchGithubRepoData().body() as GithubReposDataModel
        } catch (e: Exception) {
            Log.d("githubException", "Error Loading the data")
            throw e
        }
    }
}