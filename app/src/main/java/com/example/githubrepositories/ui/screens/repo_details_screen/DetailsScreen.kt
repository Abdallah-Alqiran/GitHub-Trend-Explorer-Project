package com.example.githubrepositories.ui.screens.repo_details_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import com.example.githubrepositories.preview_data.fakeGitHubRepoListUIModel
import com.example.githubrepositories.ui.screens.repo_details_screen.components.TextAndIcon
import com.example.githubrepositories.ui.theme.GitHubRepositoriesTheme

@Composable
fun DetailsScreen(
    i: String,
    onDetails: () -> Unit = {}
) {
    val id = i.toInt()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .height(300.dp),
            painter = painterResource(id = fakeGitHubRepoListUIModel[id].avatar),
            contentDescription = null
        )
        Text(
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            text = fakeGitHubRepoListUIModel[id].title,
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

        Spacer(
            modifier = Modifier
                .weight(1f)
        )

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(50.dp),
            colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primary),
            elevation = ButtonDefaults.buttonElevation(3.dp),
            shape = RoundedCornerShape(20),
            onClick = {
                onDetails()
            }
        ) {
            Text(
                text = "Show Issues",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onPrimary
            )

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