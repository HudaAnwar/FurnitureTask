package com.huda.furnituretask.network.responses

import com.google.gson.annotations.SerializedName
import com.huda.furnituretask.network.model.HomeDto

data class HomeResponse(
    @SerializedName("data") var data: HomeDto? = HomeDto(),
    @SerializedName("message") var message: String? = null,
    @SerializedName("status") var status: Boolean? = null
)

