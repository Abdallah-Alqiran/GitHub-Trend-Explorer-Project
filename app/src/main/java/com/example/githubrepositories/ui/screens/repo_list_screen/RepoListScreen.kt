package com.example.githubrepositories.ui.screens.repo_list_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.githubrepositories.ui.screens.repo_list_screen.components.RepoListItem
import com.example.githubrepositories.ui.screens.repo_list_screen.priview.fakeGitHubRepoListUIModel
import com.example.githubrepositories.ui.screens.repo_list_screen.viewmodel.RepoListViewModel
import com.example.githubrepositories.ui.theme.GitHubRepositoriesTheme

@Composable
fun RepoListScreen(
    modifier: Modifier = Modifier,
    onRepoItem: (id: String) -> Unit = {},
) {
    // creating an instance of the view Model
    val repoListViewModel: RepoListViewModel = hiltViewModel()

    LaunchedEffect(Unit) {
        repoListViewModel.requestGithubRepoList()
    }

    // hello
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        items(fakeGitHubRepoListUIModel) {
            RepoListItem(onRepoItem = onRepoItem, gitHubRepoUIModel = it)
        }
    }
}


@Preview(
    showBackground = true,
)
@Composable
fun GreetingPreview() {
    GitHubRepositoriesTheme {
        RepoListScreen()
    }
}