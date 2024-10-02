package id.maxxitani.compose.presentation.screens.main

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import id.maxxitani.compose.domain.usecase.GetHelloWorldUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val helloWorldUseCase: GetHelloWorldUseCase) :
    ViewModel() {
    private val _helloWorldState = mutableStateOf("")
    val helloWorldState = _helloWorldState

    init {
        getHelloWorld()
    }

    fun getHelloWorld() = viewModelScope.launch {
        _helloWorldState.value = helloWorldUseCase.invoke()
    }
}