package com.example.githubrepositories.ui.screens.issue_screen

import com.example.githubrepositories.ui.model.CustomExceptionUiModel
import com.example.githubrepositories.ui.screens.issue_screen.model.GithubRepoIssuesUiModel


sealed class RepoIssuesUiState {
    data object InitialState: RepoIssuesUiState()
    data class Loading(val isLoading: Boolean = false): RepoIssuesUiState()
    data class Error(val customErrorExceptionUiModel: CustomExceptionUiModel): RepoIssuesUiState()
    data class RepoIssueUiModelData(val repositoryIssues: List<GithubRepoIssuesUiModel>): RepoIssuesUiState()
}