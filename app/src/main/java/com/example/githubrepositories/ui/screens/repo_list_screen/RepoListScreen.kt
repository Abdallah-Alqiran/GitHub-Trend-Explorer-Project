package com.example.githubrepositories.ui.screens.repo_list_screen

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
import com.example.githubrepositories.data.datasources.local.GithubReposLocalDataSource
import com.example.githubrepositories.ui.common_component.animate_shimmer.AnimateShimmerScreen
import com.example.githubrepositories.ui.common_component.failed_loading_screen.FailedLoadingScreen
import com.example.githubrepositories.ui.screens.repo_list_screen.components.RepoListItem
import com.example.githubrepositories.ui.screens.repo_list_screen.priview.fakeGitHubRepoListUIState
import com.example.githubrepositories.ui.screens.repo_list_screen.viewmodel.RepoListViewModel
import com.example.githubrepositories.ui.theme.GitHubRepositoriesTheme

@Composable
fun RepoListScreen(
    onRepoItemClicked: (id: String) -> Unit = {},
) {
    // creating an instance of the view Model
    val repoListViewModel: RepoListViewModel = hiltViewModel()

    LaunchedEffect(Unit) {
        repoListViewModel.requestGithubRepoList()
    }

    val repoListScreen by repoListViewModel.repoListStateFlow.collectAsStateWithLifecycle()

    RepoListContent(
        repoListScreen,
        onRefreshButtonClicked = { repoListViewModel.requestGithubRepoList() },
        onRepoItemClicked
    )
}

@Composable
fun RepoListContent(
    repoListScreen: RepoListScreenUiState,
    onRefreshButtonClicked:() -> Unit = {},
    onRepoItemClicked: (id: String) -> Unit
) {
    when {
        repoListScreen.isLoading -> {
            AnimateShimmerScreen()
        }
        repoListScreen.isError -> {
            FailedLoadingScreen(
                errorMessage = repoListScreen.customErrorExceptionUiModel.toString(),
                onFailed = onRefreshButtonClicked
            )
        }
        else -> {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background)
            ) {
                items(repoListScreen.gitHubRepoUIModel) {
                    RepoListItem(onRepoItem = onRepoItemClicked, gitHubRepoUIModel = it)
                }
            }
        }
    }
}


@Preview(
    showBackground = true,
)
@Composable
fun GreetingPreview() {
    GitHubRepositoriesTheme {
        RepoListContent(
            fakeGitHubRepoListUIState,
            onRefreshButtonClicked = {},
            onRepoItemClicked = {}
        )
    }
}