package com.example.githubrepositories

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode.Companion.Color
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.githubrepositories.ui.theme.GitHubRepositoriesTheme

@Composable
fun FirstPage(modifier: Modifier = Modifier) {
    Row(modifier = Modifier
        .padding(8.dp)
        .fillMaxWidth()
        .background(
            MaterialTheme.colorScheme.primaryContainer,
            shape = RoundedCornerShape(12.dp)
        )
        .clickable {

        }
    ) {
        Image(
            painter = painterResource(id = R.drawable.happy_face),
            contentDescription = null,
            modifier = DefaultImageModifier()
        )

        Column(
            modifier = Modifier
                .padding(8.dp)
        ) {
            Row (
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Hello!!",
                    // the same as the spacer
                    modifier = Modifier.weight(1f)
                )

//                Spacer(Modifier.weight(1f))

                Text("123456")
                Image(painter = painterResource(id = R.drawable.happy_face),
                    contentDescription = null,
                    // change the SVG image color
                    colorFilter = ColorFilter.tint(color = Yellow),
                    modifier = Modifier.padding(start = 5.dp)
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "profile name",
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            Text(
                text = "description description description description ",
                maxLines = 4,
                overflow = TextOverflow.Ellipsis
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
        FirstPage()
    }
}