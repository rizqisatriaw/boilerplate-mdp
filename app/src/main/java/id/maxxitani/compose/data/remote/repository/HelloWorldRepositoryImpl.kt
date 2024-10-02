package id.maxxitani.compose.data.remote.repository

import id.maxxitani.compose.data.remote.HelloWorldServices
import id.maxxitani.compose.domain.repository.HelloWorldRepository
import javax.inject.Inject

class HelloWorldRepositoryImpl @Inject constructor(services: HelloWorldServices) :
    HelloWorldRepository {
    override fun getHelloWorld(): String = "Hello World!"
}