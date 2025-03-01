package com.example.githubrepositories.data.datasources.remote.retrofit.api

import com.example.githubrepositories.data.Constants.Companion.OWNER_KEY
import com.example.githubrepositories.data.Constants.Companion.REPO_NAME_KEY
import com.example.githubrepositories.data.datasources.remote.retrofit.model.for_issues.Issues
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RepoIssuesApi {
    @GET("repos/{$OWNER_KEY}/{$REPO_NAME_KEY}/issues")
    suspend fun fetchIssueDetails(
        @Path(OWNER_KEY) owner: String,
        @Path(REPO_NAME_KEY) name: String
    ): Response<Issues>
}