package com.example.githubrepositories.data.datasources.remote.retrofit.api

import com.example.githubrepositories.data.Constants.Companion.END_REMOTE_URL
import com.example.githubrepositories.data.datasources.remote.retrofit.model.GithubReposDataModel
import retrofit2.Response
import retrofit2.http.GET

// creating an Interface for API endpoints
// Hilt can't deal with interface so
// In the Network Module we will make it's module
interface GithubAPI {
    @GET(END_REMOTE_URL)
    fun fetchGithubRepoData(): Response<GithubReposDataModel>
}