package com.example.githubrepositories.ui.screens.repo_list_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.githubrepositories.ui.screens.repo_list_screen.components.RepoListItem
import com.example.githubrepositories.ui.screens.repo_list_screen.preview.fakeGitHubRepoListUIModel
import com.example.githubrepositories.ui.theme.GitHubRepositoriesTheme

@Composable
fun RepoListScreen(
    modifier: Modifier = Modifier,
    onRepoItem: (id: String) -> Unit = {},
) {

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