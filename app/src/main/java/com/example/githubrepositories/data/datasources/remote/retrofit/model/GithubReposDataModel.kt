package com.example.githubrepositories.data.datasources.remote.retrofit.model

import com.google.gson.annotations.SerializedName

// the data we get from the API
data class GithubReposDataModel(
    @SerializedName("incomplete_results")
    val incompleteResults: Boolean,
    val items: List<Item>,
    @SerializedName("total_count")
    val totalCount: Int
)
