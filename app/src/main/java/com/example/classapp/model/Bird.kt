package com.example.classapp.model

import com.squareup.moshi.Json

data class Bird(
    @Json(name = "comName")
    val comName: String,
    @Json(name = "howMany")
    val howMany: Int,
    @Json(name = "lat")
    val lat: Double,
    @Json(name = "lng")
    val lng: Double,
    @Json(name = "locId")
    val locId: String,
    @Json(name = "locName")
    val locName: String,
    @Json(name = "locationPrivate")
    val locationPrivate: Boolean,
    @Json(name = "obsDt")
    val obsDt: String,
    @Json(name = "obsReviewed")
    val obsReviewed: Boolean,
    @Json(name = "obsValid")
    val obsValid: Boolean,
    @Json(name = "sciName")
    val sciName: String,
    @Json(name = "speciesCode")
    val speciesCode: String,
    @Json(name = "subId")
    val subId: String,
    var id: Int, //None provided by API
)
