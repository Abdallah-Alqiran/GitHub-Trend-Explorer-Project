package com.example.githubrepositories.ui.mapper

import com.example.githubrepositories.domain.model.GithubRepoDetailsDomainModel
import com.example.githubrepositories.ui.screens.details_screen.model.GithubRepoDetailsUiModel

fun GithubRepoDetailsDomainModel.toRepositoryDetailsUiModel(): GithubRepoDetailsUiModel {
    return GithubRepoDetailsUiModel(
    id = this.id,
    name = this.name,
    avatar = this.avatar,
    description = this.description,
    forks = this.forks,
    language = this.language,
    fullName = this.fullName,
    stars = this.stars,
    url = this.url,
    owner = this.owner,
    createdAt = this.createdAt
    )
}