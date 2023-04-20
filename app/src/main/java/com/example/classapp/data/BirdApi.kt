package com.example.classapp.data

import com.example.classapp.model.Bird
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface BirdApi {
    @Headers("x-ebirdapitoken: vi5ddl2dppc5")
    @GET("/v2/data/obs/US-KY/recent")
    suspend fun getBirds(@Query("maxResults") totalResults : Int): Response<List<Bird>>
}