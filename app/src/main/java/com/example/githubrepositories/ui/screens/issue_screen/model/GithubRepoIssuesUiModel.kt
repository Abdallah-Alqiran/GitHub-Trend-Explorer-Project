package com.example.githubrepositories.ui.screens.issue_screen.model

data class GithubRepoIssuesUiModel(
    val id: Long,
    val title: String,
    val author: String,
    val state: String,
    val date: String,
    val repositoryUrl: String
)