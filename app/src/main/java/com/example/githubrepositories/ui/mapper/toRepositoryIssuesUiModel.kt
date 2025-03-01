package com.example.githubrepositories.ui.mapper

import com.example.githubrepositories.domain.model.GithubRepoIssuesDomainModel
import com.example.githubrepositories.ui.screens.issue_screen.model.GithubRepoIssuesUiModel

fun GithubRepoIssuesDomainModel.toRepositoryIssuesUiModel(): GithubRepoIssuesUiModel {
    return GithubRepoIssuesUiModel(
        id = this.id,
        title = this.title,
        author = this.author,
        state = this.state,
        date = this.date,
        repositoryUrl = this.repositoryUrl
    )
}