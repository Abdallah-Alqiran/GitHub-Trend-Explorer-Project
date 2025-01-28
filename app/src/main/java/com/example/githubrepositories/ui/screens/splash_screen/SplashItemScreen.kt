package com.example.githubrepositories.ui.screens.splash_screen

import android.widget.ImageView
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.res.ResourcesCompat
import com.example.githubrepositories.R
import com.example.githubrepositories.ui.theme.GitHubRepositoriesTheme

@Composable
fun SplashItemScreen(modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
            .padding(8.dp)
    ) {
        Box(
            modifier = Modifier
                .size(50.dp)
                .background(MaterialTheme.colorScheme.surface, CircleShape)
        )
        Column() {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                FakeText(height = 25, width = 150)
                FakeText(height = 25, width = 70)
            }
            FakeText(height = 25, width = 150)
            FakeText(height = 45, width = 300)
        }
    }
}


@Composable
fun FakeText(height: Int, width: Int, modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .height(height.dp)
            .width(width.dp)
            .padding(start = 8.dp, top = 8.dp)
            .background(MaterialTheme.colorScheme.surface, RoundedCornerShape(20)),
    )
}

@Preview
@Composable
private fun Prev() {
    GitHubRepositoriesTheme {
        SplashItemScreen()
    }
}