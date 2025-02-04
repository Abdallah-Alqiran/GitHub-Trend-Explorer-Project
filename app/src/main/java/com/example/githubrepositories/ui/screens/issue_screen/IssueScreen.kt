package com.example.githubrepositories.ui.screens.issue_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.githubrepositories.ui.screens.issue_screen.components.IssueItemScreen
import com.example.githubrepositories.ui.theme.GitHubRepositoriesTheme


@Composable
fun IssueScreen() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        items(50) {
            IssueItemScreen()
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
private fun Prev() {
    GitHubRepositoriesTheme {
        IssueScreen()
    }
}