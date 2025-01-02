package com.example.githubrepositories.ui.screens.repo_list_screen.model

data class GitHubRepoUIModel(
    val id: Int,
    val title: String,
    val avatar: Int,
    val description: String,
    val stars: Int,
    val owner: String
)
