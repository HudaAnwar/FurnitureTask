package com.huda.furnituretask.network.model

import com.google.gson.annotations.SerializedName

data class RegisterMessageDto(
    @SerializedName("name")
    var name: List<String>,
    @SerializedName("email")
    var email: List<String>,
    @SerializedName("country_code")
    var countryCode: List<String>,
    @SerializedName("phone")
    var phone: List<String>,
    @SerializedName("password")
    var password: List<String>,
    @SerializedName("password_confirmation")
    var passwordConfirmation: List<String>,
    @SerializedName("address")
    var address: List<String>
)
