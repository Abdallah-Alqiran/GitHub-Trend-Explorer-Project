package com.example.githubrepositories.ui.mapper

import com.example.githubrepositories.domain.model.GithubRepoListDomainModel
import com.example.githubrepositories.ui.screens.repo_list_screen.model.GitHubRepoUIModel

fun GithubRepoListDomainModel.toGithubRepoUiModel(): GitHubRepoUIModel {
    return GitHubRepoUIModel(
        id = this.id,
        name = this.name,
        avatar = this.avatar,
        description = this.description,
        stars = this.stars,
        owner = this.owner
    )
}