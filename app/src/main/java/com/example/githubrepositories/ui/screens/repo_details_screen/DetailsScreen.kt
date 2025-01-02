package com.example.githubrepositories.ui.screens.repo_details_screen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun DetailsScreen(
    id: String,
    modifier: Modifier = Modifier
) {
    Text(text = id)
}