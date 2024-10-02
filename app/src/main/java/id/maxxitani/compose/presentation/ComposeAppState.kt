package id.maxxitani.compose.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.CoroutineScope

@Composable
fun rememberComposeAppState(
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    navController: NavHostController = rememberNavController(),
    isOpenBottomSheet: MutableState<Boolean> =
        remember {
            mutableStateOf(false)
        },
) = remember(
    coroutineScope,
    navController,
) {
    RememberAppState(
        coroutineScope,
        navController,
    )
}

class RememberAppState(
    private val coroutineScope: CoroutineScope,
    val navController: NavHostController,
) {
    private val currentRoute: String?
        get() = navController.currentDestination?.route
}