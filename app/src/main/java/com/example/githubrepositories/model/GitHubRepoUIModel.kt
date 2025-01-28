package com.example.githubrepositories.model

data class GitHubRepoUIModel(
    val id: Int,
    val title: String,
    val avatar: Int,
    val description: String,
    val stars: Int,
    val owner: String
)
