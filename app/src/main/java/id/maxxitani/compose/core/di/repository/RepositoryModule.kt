package id.maxxitani.compose.core.di.repository

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import id.maxxitani.compose.data.remote.repository.HelloWorldRepositoryImpl
import id.maxxitani.compose.domain.repository.HelloWorldRepository

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun providesHelloWorldRepository(helloWorldRepositoryImpl: HelloWorldRepositoryImpl): HelloWorldRepository
}