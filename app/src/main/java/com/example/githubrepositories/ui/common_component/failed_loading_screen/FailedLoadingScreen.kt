package com.example.githubrepositories.ui.common_component.failed_loading_screen
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.githubrepositories.R
import com.example.githubrepositories.ui.model.CustomExceptionUiModel
import com.example.githubrepositories.ui.pieces.default_button.DefaultButton
import com.example.githubrepositories.ui.theme.GitHubRepositoriesTheme

@Composable
fun FailedLoadingScreen(onFailed: () -> Unit = {}, errorMessage: String = "") {
    // Load animation from the raw folder
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.error_animation))

    // control animation state
    val progress by animateLottieCompositionAsState(
        composition = composition,
        iterations = LottieConstants.IterateForever
    )


    // Display the animation
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        LottieAnimation(
            composition = composition,
            progress = progress,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .weight(1f)
        )

        Text(
            text = "Something Went Wrong..",
            style = MaterialTheme.typography.titleLarge
        )
        Text(
            modifier = Modifier.padding(horizontal = 16.dp),
            text = errorMessage,
            style = MaterialTheme.typography.titleMedium,
            color = Color.Gray
        )

        DefaultButton(
            text = "RETRY",
            borderColor = MaterialTheme.colorScheme.onPrimaryContainer,
            color = MaterialTheme.colorScheme.background,
            textColor = MaterialTheme.colorScheme.onPrimaryContainer,
            onClick = onFailed
        )
    }

}

@Preview(showBackground = true)
@Composable
private fun Prev() {
    GitHubRepositoriesTheme {
        FailedLoadingScreen()
    }
}