package com.example.githubrepositories.ui.screens.repo_list_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.githubrepositories.DefaultImageModifier
import com.example.githubrepositories.R
import com.example.githubrepositories.ui.screens.repo_list_screen.RepoListScreen
import com.example.githubrepositories.ui.screens.repo_list_screen.model.GitHubRepoUIModel
import com.example.githubrepositories.ui.theme.GitHubRepositoriesTheme

@Composable
fun RepoListItem(
    gitHubRepoUIModel: GitHubRepoUIModel,
    modifier: Modifier = Modifier,
    onRepoItem: (id: String) -> Unit = {},
) {
    Row(modifier = Modifier
        .padding(8.dp)
        .fillMaxWidth()
        .background(
            // for best practice this is a surface
            MaterialTheme.colorScheme.surface,
            shape = MaterialTheme.shapes.medium,
        )
        .clickable {
            onRepoItem(gitHubRepoUIModel.id.toString())
        }
    ) {
        DefaultImageModifier(img = gitHubRepoUIModel.avatar)

        Column(
            modifier = Modifier
                .padding(8.dp)
        ) {
            Row (
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = gitHubRepoUIModel.title,
                    // the same as the spacer
                    modifier = Modifier.weight(1f),
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSurface
                )

//                Spacer(Modifier.weight(1f))

                Text(
                    text = gitHubRepoUIModel.stars.toString(),
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.bodyMedium
                )

                Image(painter = painterResource(id = R.drawable.star),
                    contentDescription = null,
                    // change the SVG image color
                    colorFilter = ColorFilter.tint(color = Yellow),
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .size(30.dp)
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = gitHubRepoUIModel.owner,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = gitHubRepoUIModel.description,
                maxLines = 4,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface
            )
        }

    }
}

@Preview(
    showBackground = true,
)
@Composable
fun GreetingPreview() {
    GitHubRepositoriesTheme {
        RepoListScreen(
            onRepoItem = {}
        )
    }
}