package com.example.githubrepositories.data.mapper

import com.example.githubrepositories.data.datasources.remote.retrofit.model.for_details.GithubDetailsDataModel
import com.example.githubrepositories.domain.model.GithubRepoDetailsDomainModel

fun GithubDetailsDataModel.toGithubRepoDetailsDomainModel(): GithubRepoDetailsDomainModel{
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