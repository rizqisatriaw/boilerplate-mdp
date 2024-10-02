package id.maxxitani.compose.presentation.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun HelloWorldComponent(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        color = Color.Black,
        modifier = modifier
    )
}