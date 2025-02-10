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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.githubrepositories.R
import com.example.githubrepositories.ui.screens.repo_list_screen.priview.fakeGitHubRepoListUIModel
import com.example.githubrepositories.ui.pieces.default_button.DefaultButton
import com.example.githubrepositories.ui.screens.details_screen.components.TextAndIcon
import com.example.githubrepositories.ui.theme.GitHubRepositoriesTheme

@Composable
fun DetailsScreen(
    i: String,
    onDetails: () -> Unit = {}
) {
    val id = i.toInt()
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
                painter = painterResource(id = fakeGitHubRepoListUIModel[id].avatar.toInt()),
                contentDescription = null
            )
            Text(
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                text = fakeGitHubRepoListUIModel[id].name,
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
                    fakeGitHubRepoListUIModel[id].stars.toString(),
                    R.drawable.star
                )
                TextAndIcon(
                    fakeGitHubRepoListUIModel[id].owner,
                    R.drawable.blue_circle
                )
                TextAndIcon(
                    123456.toString(),
                    R.drawable.ic_fork
                )
            }


            Text(
                modifier = Modifier.padding(horizontal = 16.dp),
                text = fakeGitHubRepoListUIModel[id].description,
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
        DetailsScreen(i = 0.toString())
    }
}