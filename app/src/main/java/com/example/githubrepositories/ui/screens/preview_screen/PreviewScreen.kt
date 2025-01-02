package com.example.githubrepositories.ui.screens.preview_screen

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.githubrepositories.ui.navigation.AppNavHost
import com.example.githubrepositories.ui.top_app_bar.TopBar

@Composable
fun PreviewScreen(modifier: Modifier = Modifier) {

    var appBarTitle: String by remember {
        mutableStateOf(
            "Github Repositories"
        )
    }

    Scaffold(
        topBar = { TopBar(title = appBarTitle) }
    ) {
        AppNavHost(modifier = Modifier.padding(it), onTitleChange = {newTitle -> appBarTitle = newTitle})
    }
}