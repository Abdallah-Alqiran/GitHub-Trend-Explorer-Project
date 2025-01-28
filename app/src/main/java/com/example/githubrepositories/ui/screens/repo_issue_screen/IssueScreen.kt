package com.example.githubrepositories.ui.screens.repo_issue_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.githubrepositories.R
import com.example.githubrepositories.preview_data.fakeGitHubRepoListUIModel
import com.example.githubrepositories.ui.pieces.default_image_modifier.DefaultImageModifier
import com.example.githubrepositories.ui.screens.repo_issue_screen.components.IssueItemScreen
import com.example.githubrepositories.ui.screens.repo_list_screen.components.RepoListItem
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