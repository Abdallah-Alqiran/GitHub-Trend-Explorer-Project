package com.example.githubrepositories.ui.screens.issue_screen

import com.example.githubrepositories.domain.model.GithubRepoIssuesDomainModel
import com.example.githubrepositories.ui.model.CustomExceptionUiModel


sealed class RepoIssuesUiState {
    data object InitialState: RepoIssuesUiState()
    data class Loading(val isLoading: Boolean = false): RepoIssuesUiState()
    data class Error(val customErrorExceptionUiModel: CustomExceptionUiModel): RepoIssuesUiState()
    data class RepoIssueUiModelData(val repositoryIssues: GithubRepoIssuesDomainModel): RepoIssuesUiState()
}