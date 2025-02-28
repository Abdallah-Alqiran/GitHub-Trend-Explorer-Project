package com.example.githubrepositories.data.datasources.remote.retrofit.api

import com.example.githubrepositories.data.datasources.remote.retrofit.model.Item
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RepoDetailsApi {
    @GET("repos/{owner}/{repo}")
    suspend fun fetchRepoDetails(
        @Path("owner") owner: String,
        @Path("repo") name: String
    ): Response<Item>

}