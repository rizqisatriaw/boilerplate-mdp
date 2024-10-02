package id.maxxitani.compose.presentation.navigation


sealed class Screen(val route: String) {
    data object MainScreen : Screen("main_screen")
    data object SecondaryScreen : Screen("secondary_screen")
}
