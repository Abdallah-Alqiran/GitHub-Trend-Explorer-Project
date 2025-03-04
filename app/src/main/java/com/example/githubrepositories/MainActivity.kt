package com.example.githubrepositories

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.githubrepositories.ui.screens.preview_screen.PreviewScreen
import com.example.githubrepositories.ui.theme.GitHubRepositoriesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GitHubRepositoriesTheme {
                PreviewScreen()
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun PreviewAll() {
    GitHubRepositoriesTheme {
        PreviewScreen()
    }
}



