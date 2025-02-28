package com.example.githubrepositories.ui.screens.details_screen

import com.example.githubrepositories.ui.model.CustomExceptionUiModel
import com.example.githubrepositories.ui.screens.details_screen.model.GithubRepoDetailsUiModel

sealed class RepoDetailsUiState {
    data object InitialState: RepoDetailsUiState()
    data class RepoDetailsUiModelData(val repositoryDetails: GithubRepoDetailsUiModel): RepoDetailsUiState()
    data class Loading(val isLoading: Boolean = true): RepoDetailsUiState()
    data class Error(val customErrorExceptionUiModel: CustomExceptionUiModel): RepoDetailsUiState()

}