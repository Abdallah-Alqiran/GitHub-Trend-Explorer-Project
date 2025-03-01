package com.example.githubrepositories.data.datasources.remote.retrofit.model.for_repo

import com.example.githubrepositories.data.datasources.remote.retrofit.model.for_details.GithubDetailsDataModel
import com.google.gson.annotations.SerializedName

// the data we get from the API
data class GithubReposDataModel(
    @SerializedName("incomplete_results")
    val incompleteResults: Boolean,
    val githubDetailsDataModels: List<GithubDetailsDataModel>,
    @SerializedName("total_count")
    val totalCount: Int
)
