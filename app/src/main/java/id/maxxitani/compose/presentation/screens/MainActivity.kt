package id.maxxitani.compose.presentation.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import dagger.hilt.android.AndroidEntryPoint
import id.maxxitani.compose.presentation.navigation.Screen
import id.maxxitani.compose.presentation.navigation.addNavigationGraph
import id.maxxitani.compose.presentation.rememberComposeAppState
import id.maxxitani.compose.presentation.theme.ComposeboilerplateTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val appState = rememberComposeAppState()
            ComposeboilerplateTheme {
                Scaffold(modifier = Modifier.fillMaxSize(), content = { padding ->
                    Box {
                        NavHost(
                            navController = appState.navController,
                            startDestination = Screen.MainScreen.route,
                            modifier =
                            Modifier
                                .background(Color.White)
                                .padding(padding)
                                .statusBarsPadding()
                                .navigationBarsPadding(),
                        ) {
                            addNavigationGraph(
                                appState.navController,
                            )
                        }
                    }
                })
            }
        }
    }
}