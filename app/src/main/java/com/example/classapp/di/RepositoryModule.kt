package com.example.classapp.di

import com.example.classapp.data.repository.BirdRepository
import com.example.classapp.data.repository.BirdRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindBirdRepository(
        birdRepositoryImpl: BirdRepositoryImpl,
    ): BirdRepository
}