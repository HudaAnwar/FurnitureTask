package com.huda.furnituretask.network.responses

import com.google.gson.annotations.SerializedName
import com.huda.furnituretask.network.model.RegisterMessageDto

data class RegistrationResponse(
    @SerializedName("data")
    var data: String? = null,
    @SerializedName("message")
    var message: RegisterMessageDto? = null,
    @SerializedName("status")
    var status: Boolean = false

)