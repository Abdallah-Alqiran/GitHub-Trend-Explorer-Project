package com.example.githubrepositories.ui.screens.repo_issue_screen.components


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.githubrepositories.R
import com.example.githubrepositories.ui.pieces.default_image_modifier.DefaultImageModifier
import com.example.githubrepositories.ui.theme.GitHubRepositoriesTheme


@Composable
fun IssueItemScreen() {
    Row(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colorScheme.errorContainer,
                shape = MaterialTheme.shapes.medium
            )
            .clickable {

            }

    ) {
        DefaultImageModifier(img = R.drawable.ic_issues)

        Column(
            Modifier.padding(8.dp)
        ) {

            Row {
                Text(
                    text = "Issue Title",
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.weight(1f),
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onErrorContainer
                )
                Text(
                    text = "Open",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onErrorContainer
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "NONE",
                maxLines = 4,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onErrorContainer

            )

            Spacer(Modifier.height(2.dp))

            Row() {

                Text(
                    text = "Created At: ",
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = Bold
                )
                Text(
                    text = "2005-6-7",
                    style = MaterialTheme.typography.labelMedium
                )
            }

        }

    }
}

@Preview(
    showBackground = true
)
@Composable
private fun Prev() {
    GitHubRepositoriesTheme {
        IssueItemScreen()
    }
}