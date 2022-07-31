package com.huda.furnituretask.network.model

import com.google.gson.annotations.SerializedName

data class LoginInformation(
    @SerializedName("username")
    var username: String,
    @SerializedName("password")
    var password: String
)
