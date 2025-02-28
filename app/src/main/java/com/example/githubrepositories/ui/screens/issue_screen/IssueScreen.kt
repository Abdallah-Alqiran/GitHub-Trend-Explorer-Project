package com.example.githubrepositories.ui.screens.issue_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.githubrepositories.domain.model.GithubRepoIssuesDomainModel
import com.example.githubrepositories.ui.common_component.animate_shimmer.AnimateShimmerScreen
import com.example.githubrepositories.ui.common_component.failed_loading_screen.FailedLoadingScreen
import com.example.githubrepositories.ui.screens.issue_screen.components.IssueItemScreen
import com.example.githubrepositories.ui.screens.issue_screen.viewmodel.IssueScreenViewModel
import com.example.githubrepositories.ui.theme.GitHubRepositoriesTheme


@Composable
fun IssueScreen(
    owner: String,
    name: String
) {

    val repoIssueViewModel: IssueScreenViewModel = hiltViewModel()

    LaunchedEffect(key1 = true) {
        repoIssueViewModel.requestGithubRepoIssues(owner, name)
    }

    val repoIssueUiState by repoIssueViewModel.repoIssuesStateFlow.collectAsStateWithLifecycle()

    when(repoIssueUiState) {
        RepoIssuesUiState.InitialState -> {}

        is RepoIssuesUiState.Error -> {
            FailedLoadingScreen(
                onFailed = {
                    repoIssueViewModel.requestGithubRepoIssues(owner, name)
                },
                errorMessage = "${(repoIssueUiState as RepoIssuesUiState.Error).customErrorExceptionUiModel} Error"
            )
        }

        is RepoIssuesUiState.Loading -> {
            if ((repoIssueUiState as RepoIssuesUiState.Loading).isLoading) {
                AnimateShimmerScreen()
            }
        }
        is RepoIssuesUiState.RepoIssueUiModelData -> {
            IssueDetailsContent(
                repoIssueUiModel = (repoIssueUiState as RepoIssuesUiState.RepoIssueUiModelData).repositoryIssues
            )
        }
    }

}

@Composable
fun IssueDetailsContent(
    repoIssueUiModel :GithubRepoIssuesDomainModel
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        items(1) { issue ->
            IssueItemScreen(repoIssueUiModel)
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
private fun Prev() {
    GitHubRepositoriesTheme {

    }
}