package com.huda.furnituretask.network.responses

import com.google.gson.annotations.SerializedName
import com.huda.furnituretask.network.model.CustomerDto

data class LoginResponse(
    @SerializedName("data")
    var data: CustomerDto? = null,
    @SerializedName("message")
    var message: String = "فشل تسجيل الدخول",
    @SerializedName("status")
    var status: Boolean = false
)