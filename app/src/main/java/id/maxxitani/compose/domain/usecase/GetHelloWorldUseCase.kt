package id.maxxitani.compose.domain.usecase

import id.maxxitani.compose.domain.repository.HelloWorldRepository
import javax.inject.Inject

class GetHelloWorldUseCase @Inject constructor(private val helloWorldRepository: HelloWorldRepository) {
    operator fun invoke(): String = helloWorldRepository.getHelloWorld()
}