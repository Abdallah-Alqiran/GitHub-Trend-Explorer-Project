package com.example.githubrepositories.data.datasources.remote.retrofit.model.unused

import com.google.gson.annotations.SerializedName

data class Reactions(
    @SerializedName("+1") val __1: Int,
    @SerializedName("-1") val _1: Int,
    val confused: Int,
    val eyes: Int,
    val heart: Int,
    val hooray: Int,
    val laugh: Int,
    val rocket: Int,
    val total_count: Int,
    val url: String
)