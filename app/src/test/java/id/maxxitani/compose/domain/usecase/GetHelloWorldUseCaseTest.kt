package id.maxxitani.compose.domain.usecase

import id.maxxitani.compose.domain.repository.HelloWorldRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class GetHelloWorldUseCaseTest {
    private lateinit var getHelloWorldUseCase: GetHelloWorldUseCase
    private lateinit var mockHelloWorldRepository: HelloWorldRepository

    @Before
    fun setup() {
        mockHelloWorldRepository = MockHelloWorldRepository()
        getHelloWorldUseCase = GetHelloWorldUseCase(mockHelloWorldRepository)
    }

    @Test
    fun `Get function value must equal Hello World!`(): Unit = runBlocking {
        val data = getHelloWorldUseCase.invoke()
        Assert.assertEquals("Hello World!", data)
    }
}