package com.example.classapp.di

import com.example.classapp.data.BirdApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun providesBirdApi(): BirdApi = Retrofit.Builder()
        .baseUrl("https://api.ebird.org")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
        .create()
}