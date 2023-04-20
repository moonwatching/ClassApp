package com.example.classapp.data.model

import com.example.classapp.model.Bird

sealed class BirdAPIResponse {
    data class Success(val birds: List<Bird>) : BirdAPIResponse()
    object Error : BirdAPIResponse()
}