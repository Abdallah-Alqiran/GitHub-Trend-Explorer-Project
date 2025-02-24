package com.example.githubrepositories.ui.screens.preview_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.githubrepositories.R
import com.example.githubrepositories.ui.navigation.AppNavHost
import com.example.githubrepositories.ui.theme.GitHubRepositoriesTheme

@Composable
fun PreviewScreen(
) {

    val navController = rememberNavController()
    var appBarTitle: String by remember {
        mutableStateOf(
            ""
        )
    }

    var showArrow: Boolean by remember {
        mutableStateOf(
            false
        )
    }

    Scaffold(
        topBar = {
            TopAppBar(text = appBarTitle, showArrow = showArrow, navController)
        }
    ) {
        AppNavHost(
            modifier = Modifier.padding(it),
            onPageChange = { newTitle, check ->
                appBarTitle = newTitle
                showArrow = check
            },
            navController
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(text: String, showArrow: Boolean, navController: NavHostController) {
    TopAppBar(
        title = {
            Row(
                Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = text,
                )
            }
        },
        navigationIcon = {
            if (showArrow) {
                IconButton(onClick = {
                    navController.popBackStack()
                }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_back_arrow),
                        contentDescription = null
                    )
                }
            }
        },
        colors = TopAppBarDefaults
            .topAppBarColors(
                MaterialTheme.colorScheme.surface
            )
    )
}

@Preview
@Composable
fun Prev(modifier: Modifier = Modifier) {
    GitHubRepositoriesTheme {
        PreviewScreen()
    }
}