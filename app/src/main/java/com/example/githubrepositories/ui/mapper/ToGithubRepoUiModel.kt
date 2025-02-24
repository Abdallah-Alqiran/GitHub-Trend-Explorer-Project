package com.example.githubrepositories.ui.mapper

import com.example.githubrepositories.domain.model.GithubRepoDomainModel
import com.example.githubrepositories.ui.screens.repo_list_screen.model.GitHubRepoUIModel

fun GithubRepoDomainModel.toGithubRepoUiModel(): GitHubRepoUIModel {
    return GitHubRepoUIModel(
        id = this.id,
        name = this.name,
        avatar = this.avatar,
        description = this.description,
        stars = this.stars,
        owner = this.owner
    )
}