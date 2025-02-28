package com.example.githubrepositories.domain.model

data class GithubRepoIssuesDomainModel(
    val title: String? = "",
    val body: String? = "",
    val locked: Boolean,
    val createdAt: String,
    val repositoryUrl: String? = ""
)