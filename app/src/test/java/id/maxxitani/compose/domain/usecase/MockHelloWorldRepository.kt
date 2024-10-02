package id.maxxitani.compose.domain.usecase

import id.maxxitani.compose.domain.repository.HelloWorldRepository

class MockHelloWorldRepository : HelloWorldRepository {
    override fun getHelloWorld(): String = "Hello World!"
}