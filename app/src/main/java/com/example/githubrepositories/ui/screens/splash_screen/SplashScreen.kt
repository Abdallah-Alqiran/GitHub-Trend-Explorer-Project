package com.example.githubrepositories.ui.screens.splash_screen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(onSplash: () -> Unit = {}, modifier: Modifier = Modifier) {
    LazyColumn {
        items(20) {
            SplashItemScreen()
        }
    }

    LaunchedEffect(Unit) {
        delay(2000)
        onSplash()
    }
}