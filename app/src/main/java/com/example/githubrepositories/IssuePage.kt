package com.example.githubrepositories

import android.text.TextUtils.EllipsizeCallback
import android.text.TextUtils.ellipsize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.InspectableModifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max

@Preview(
    showBackground = true
)
@Composable
fun IssuePage() {
    Row(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colorScheme.errorContainer,
                shape = RoundedCornerShape(12.dp)
            )
            .clickable {

            }
    ) {
        Image(
            painter = painterResource(id = R.drawable.sad_face),
            contentDescription = null,
            modifier = DefaultImageModifier()
        )

        Column(
            Modifier.padding(8.dp)
        ) {

            Row {
                Text(
                    text = "Issue Title",
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.weight(1f),
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Open",
                )
            }

            Spacer(Modifier.height(4.dp))

            Text(
                text = "NONE",
                maxLines = 4,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(Modifier.height(2.dp))

            Text(
                text = buildAnnotatedString {
                    // from gpt
                    withStyle(
                        style = SpanStyle(fontWeight =  FontWeight.Bold)
                    ) {
                        append("Created At: ")
                    }
                    append("2005-6-7")
                },
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

        }

    }
}