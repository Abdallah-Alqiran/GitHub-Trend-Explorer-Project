package com.example.githubrepositories.ui.pieces.default_image_modifier

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun DefaultImageModifier(img: Int) {
    Image(
        painter = painterResource(id = img),
        contentDescription = null,
        Modifier
            .padding(start = 8.dp, top = 8.dp)
            .size(50.dp)
            .clip(shape = CircleShape)
    )
}
