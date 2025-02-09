package com.example.githubrepositories.data.datasources.remote.retrofit.api

import com.example.githubrepositories.data.Constants.Companion.END_REMOTE_URL
import com.example.githubrepositories.data.datasources.remote.retrofit.model.GithubReposDataModel
import retrofit2.Response
import retrofit2.http.GET

interface GithubAPI {
    @GET(END_REMOTE_URL)
    fun fetchGithubRepoData(): Response<GithubReposDataModel>
}