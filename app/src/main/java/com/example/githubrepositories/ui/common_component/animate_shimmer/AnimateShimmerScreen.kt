package com.example.githubrepositories.ui.common_component.animate_shimmer

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import kotlinx.coroutines.delay

@Composable
fun AnimateShimmerScreen(onSplash: () -> Unit = {}) {
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