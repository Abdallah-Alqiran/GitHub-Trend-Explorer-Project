package com.example.githubrepositories.domain.model


// the data we will use in the business logic
// that we want to show in the UI
data class GithubRepoListDomainModel(
    val id: Int,
    val name: String,
    val avatar: String,
    val description: String,
    val owner: String,
    val stars: Int
)
