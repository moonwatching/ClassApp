package com.example.classapp.data.repository

import com.example.classapp.data.model.BirdAPIResponse

interface BirdRepository {
    suspend fun getBirds(birdCount: Int): BirdAPIResponse
}