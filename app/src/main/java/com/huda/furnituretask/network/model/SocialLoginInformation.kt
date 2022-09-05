package com.huda.furnituretask.network.model

import com.google.gson.annotations.SerializedName

data class SocialLoginInformation(
    @SerializedName("provider_type")
    var providerType: String,
    @SerializedName("provider_id")
    var providerId: String,
    @SerializedName("name")
    var name: String?,
    @SerializedName("email")
    var email: String?
)

data class CheckSocialLoginInformation(
    @SerializedName("provider_type")
    var providerType: String,
    @SerializedName("provider_id")
    var providerId: String,
)