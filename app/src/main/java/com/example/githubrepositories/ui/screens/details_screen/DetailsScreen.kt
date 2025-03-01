package com.example.githubrepositories.ui.screens.details_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.githubrepositories.R
import com.example.githubrepositories.ui.common_component.animate_shimmer.AnimateShimmerScreen
import com.example.githubrepositories.ui.common_component.failed_loading_screen.FailedLoadingScreen
import com.example.githubrepositories.ui.pieces.default_button.DefaultButton
import com.example.githubrepositories.ui.screens.details_screen.components.TextAndIcon
import com.example.githubrepositories.ui.screens.details_screen.model.GithubRepoDetailsUiModel
import com.example.githubrepositories.ui.screens.details_screen.preview.fakeGitHubDetailsUIModel
import com.example.githubrepositories.ui.screens.details_screen.viewmodel.DetailsViewModel
import com.example.githubrepositories.ui.theme.GitHubRepositoriesTheme

@Composable
fun DetailsScreen(
    owner: String,
    name: String,
    onDetails: () -> Unit = {}
) {

    val repoDetailsViewModel: DetailsViewModel = hiltViewModel()
    LaunchedEffect(key1 = true) {
        repoDetailsViewModel.requestGithubRepoDetails(owner, name)
    }
    val repoDetailsUiState by repoDetailsViewModel.repoDetailsStateFlow.collectAsStateWithLifecycle()

    when (repoDetailsUiState) {
        RepoDetailsUiState.InitialState -> {}

        is RepoDetailsUiState.Error -> {
            FailedLoadingScreen(
                onFailed = {
                    repoDetailsViewModel.requestGithubRepoDetails(owner, name)
                },
                errorMessage = "${(repoDetailsUiState as RepoDetailsUiState.Error).customErrorExceptionUiModel} Error"
            )
        }

        is RepoDetailsUiState.Loading -> {
            if ((repoDetailsUiState as RepoDetailsUiState.Loading).isLoading) {
                AnimateShimmerScreen()
            }
        }

        is RepoDetailsUiState.RepoDetailsUiModelData -> {
            RepoDetailsContent(
                repoDetailsUiModel = (repoDetailsUiState as RepoDetailsUiState.RepoDetailsUiModelData).repositoryDetails,
                onDetails = onDetails
            )
        }
    }

}

@Composable
fun RepoDetailsContent(
    repoDetailsUiModel: GithubRepoDetailsUiModel,
    onDetails: () -> Unit = {}
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        item {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .height(300.dp),
                painter = rememberAsyncImagePainter(model =
                    ImageRequest.Builder(LocalContext.current)
                        .data(repoDetailsUiModel.avatar)
                        .crossfade(1000)
                        .build()
                ),
                contentDescription = null
            )

            Text(
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                text = repoDetailsUiModel.name,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onSurface
            )


            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                TextAndIcon(
                    repoDetailsUiModel.stars.toString(),
                    R.drawable.star
                )
                TextAndIcon(
                    repoDetailsUiModel.owner,
                    R.drawable.blue_circle
                )
                TextAndIcon(
                    123456.toString(),
                    R.drawable.ic_fork
                )
            }


            Text(
                modifier = Modifier.padding(horizontal = 16.dp),
                text = repoDetailsUiModel.description,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface
            )

            DefaultButton("Show Issues", onClick = onDetails)

        }
    }
}

@Preview
@Composable
private fun Prev() {
    GitHubRepositoriesTheme {
        RepoDetailsContent(fakeGitHubDetailsUIModel)
    }
}