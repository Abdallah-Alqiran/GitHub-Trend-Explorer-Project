package com.example.githubrepositories.data.datasources.remote

import android.util.Log
import com.example.githubrepositories.data.datasources.remote.retrofit.api.GithubAPI
import com.example.githubrepositories.data.datasources.remote.retrofit.model.GithubReposDataModel
import com.example.githubrepositories.data.mapper.toCustomExceptionDomainModel
import com.example.githubrepositories.di.NetworkModule
import javax.inject.Inject

// this remote repo will deal with retrofit
// (go back to recommended app architecture)
// we will take instance from retrofit
class GithubReposRemoteDataSource @Inject constructor(
    private val githubAPI: GithubAPI
) {
    // this function will return the data if there is no errors
    suspend fun fetchGithubRepos(): GithubReposDataModel {
        return try {
            githubAPI.fetchGithubRepoData().body() as GithubReposDataModel
        } catch (e: Exception) {
            Log.d("githubException", "Error Loading the data")
            throw e.toCustomExceptionDomainModel()
        }
    }
}