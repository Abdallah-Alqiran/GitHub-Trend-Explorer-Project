package com.example.githubrepositories.data.datasources.remote.retrofit.model

import com.google.gson.annotations.SerializedName

data class GithubReposDataModel(
    @SerializedName("incomplete_results")
    val incompleteResults: Boolean,
    val items: List<Item>,
    @SerializedName("total_count")
    val totalCount: Int
)

