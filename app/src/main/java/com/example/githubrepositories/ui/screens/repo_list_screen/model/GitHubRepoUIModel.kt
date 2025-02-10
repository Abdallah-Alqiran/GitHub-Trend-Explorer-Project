package com.example.githubrepositories.ui.screens.repo_list_screen.model

data class GitHubRepoUIModel(
    val id: Int,
    val name: String,
    val avatar: String,
    val description: String,
    val owner: String,
    val stars: Int,
)
