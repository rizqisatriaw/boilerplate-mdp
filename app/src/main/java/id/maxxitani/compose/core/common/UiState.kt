package id.maxxitani.compose.core.common

sealed class UiState<T>(
    val data: T? = null,
    val errorMessage: String? = null,
) {
    class Loading<T> : UiState<T>()

    class Success<T>(data: T?) : UiState<T>(data)

    class Error<T>(
        message: String = "",
    ) : UiState<T>(
        errorMessage = message,
    )
}