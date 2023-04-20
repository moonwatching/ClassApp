package com.example.classapp.data.repository

import com.example.classapp.data.BirdApi
import com.example.classapp.data.model.BirdAPIResponse
import javax.inject.Inject

class BirdRepositoryImpl @Inject constructor(
    private val BirdApi: BirdApi,
) : BirdRepository {
    override suspend fun getBirds(birdcount: Int): BirdAPIResponse {
        val result = BirdApi.getBirds(birdcount)
        return if (result.isSuccessful) {
            BirdAPIResponse.Success(result.body() ?: emptyList())
        } else {
            BirdAPIResponse.Error
        }
    }
}
