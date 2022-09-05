package com.huda.furnituretask.network.model

import com.google.gson.annotations.SerializedName

data class Coordinates(
    @SerializedName("lat")
    var lat: Double = 0.0,
    @SerializedName("lng")
    var lng: Double = 0.0
)
