package com.example.githubrepositories.domain.model

data class GithubRepoIssuesDomainModel(
    val id: Long,
    val title: String,
    val author: String,
    val state: String,
    val date: String,
    val repositoryUrl: String
)