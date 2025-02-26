package com.example.githubrepositories.ui.screens.repo_list_screen

import com.example.githubrepositories.ui.model.CustomExceptionUiModel
import com.example.githubrepositories.ui.screens.repo_list_screen.model.GitHubRepoUIModel

data class RepoListScreenUiState(
    val isError: Boolean = false,
    val isLoading: Boolean = false,
    val customErrorExceptionUiModel: CustomExceptionUiModel? = null,
    val gitHubRepoUIModel: List<GitHubRepoUIModel> = emptyList(),
)