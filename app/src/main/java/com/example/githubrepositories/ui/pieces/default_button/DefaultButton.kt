package com.example.githubrepositories.ui.pieces.default_button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.githubrepositories.ui.theme.GitHubRepositoriesTheme

@Composable
fun DefaultButton(
    text: String,
    color: Color = MaterialTheme.colorScheme.primary,
    borderColor: Color = MaterialTheme.colorScheme.primary,
    textColor: Color = MaterialTheme.colorScheme.onPrimary,
    onClick: () -> Unit = {}
) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp)
            .padding(vertical = 60.dp)
        ,
        colors = ButtonDefaults.buttonColors(color),
        border = BorderStroke(3.dp,borderColor),
        elevation = ButtonDefaults.buttonElevation(1.dp),
        shape = RoundedCornerShape(10),
        onClick = {
            onClick()
        }
    ) {
        Text(
            modifier = Modifier.padding(5.dp),
            text = text,
            style = MaterialTheme.typography.titleLarge,
            color = textColor
        )

    }
}

@Preview
@Composable
private fun Prev() {
    GitHubRepositoriesTheme {
        DefaultButton(text = "Heloooo World")
    }
}