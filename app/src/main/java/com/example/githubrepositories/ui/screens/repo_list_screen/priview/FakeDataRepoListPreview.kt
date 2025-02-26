package com.example.githubrepositories.ui.screens.repo_list_screen.priview

import com.example.githubrepositories.R
import com.example.githubrepositories.ui.screens.repo_list_screen.RepoListScreenUiState
import com.example.githubrepositories.ui.screens.repo_list_screen.model.GitHubRepoUIModel

val fakeGitHubRepoUIModel0 = GitHubRepoUIModel(
    id = 0,
    name = "Fitness App",
    avatar = R.drawable.happy_face.toString(),
    description = "DEPI Graduation Project",
    stars = 765,
    owner = "My Team"
)

val fakeGitHubRepoUIModel1 = GitHubRepoUIModel(
    id = 1,
    name = "Fitness App",
    avatar = R.drawable.face.toString(),
    description = "DEPI Graduation Project",
    stars = 765,
    owner = "My Team"
)

val fakeGitHubRepoListUIModel = listOf(
    fakeGitHubRepoUIModel0,
    fakeGitHubRepoUIModel1,
)

val fakeGitHubRepoListUIState = RepoListScreenUiState (
    gitHubRepoUIModel = fakeGitHubRepoListUIModel,
    isLoading = true
)