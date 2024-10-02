package id.maxxitani.compose.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import id.maxxitani.compose.presentation.screens.main.MainScreen

fun NavGraphBuilder.addNavigationGraph(
    navController: NavController
) {
    composable(Screen.MainScreen.route) { from ->
        MainScreen()
    }
}