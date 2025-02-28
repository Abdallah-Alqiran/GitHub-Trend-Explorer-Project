package com.example.githubrepositories.ui.mapper

import com.example.githubrepositories.domain.model.GithubRepoIssuesDomainModel
import com.example.githubrepositories.ui.screens.issue_screen.RepoIssuesUiState

fun GithubRepoIssuesDomainModel.toRepositoryIssuesUiModel(): GithubRepoIssuesDomainModel {
    return GithubRepoIssuesDomainModel(
        title = this.title,
        body = this.body,
        locked = this.locked,
        createdAt = this.createdAt,
        repositoryUrl = this.repositoryUrl
    )
}