package com.example.githubrepositories.data.mapper

import com.example.githubrepositories.data.datasources.remote.retrofit.model.Item
import com.example.githubrepositories.domain.model.GithubRepoDetailsDomainModel

fun Item.toGithubRepoDetailsDomainModel(): GithubRepoDetailsDomainModel{
    return GithubRepoDetailsDomainModel(
        id = this.id,
        name = this.name,
        avatar = this.owner.avatar_url,
        description = this.description,
        stars = this.stargazersCount,
        owner = this.owner.login,
        forks = this.forks,
        language = this.language?: "",
        fullName = this.full_name,
        url = this.url,
        createdAt = createdAt
    )
}