package id.maxxitani.compose.presentation.screens.main

import id.maxxitani.compose.MainCoroutineRule
import id.maxxitani.compose.domain.repository.HelloWorldRepository
import id.maxxitani.compose.domain.usecase.GetHelloWorldUseCase
import id.maxxitani.compose.domain.usecase.MockHelloWorldRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class MainViewModelTest {
    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private lateinit var getHelloWorldUseCase: GetHelloWorldUseCase
    private lateinit var mockHelloWorldRepository: HelloWorldRepository
    private lateinit var viewModel: MainViewModel

    @Before
    fun setup() {
        mockHelloWorldRepository = MockHelloWorldRepository()
        getHelloWorldUseCase = GetHelloWorldUseCase(mockHelloWorldRepository)
        viewModel = MainViewModel(getHelloWorldUseCase)
    }

    @Test
    fun `Get function getHelloWorld return must equal Hello World!`() = runTest {
        advanceUntilIdle()
        Assert.assertEquals("Hello World!", viewModel.helloWorldState.value)
    }
}