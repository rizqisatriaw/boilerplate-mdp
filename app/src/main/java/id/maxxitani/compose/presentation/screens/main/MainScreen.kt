package id.maxxitani.compose.presentation.screens.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import id.maxxitani.compose.presentation.components.HelloWorldComponent

@Composable
fun MainScreen(modifier: Modifier = Modifier, viewModel: MainViewModel = hiltViewModel()) {
    val helloWorldState = viewModel.helloWorldState

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        HelloWorldComponent(text = helloWorldState.value)
    }
}