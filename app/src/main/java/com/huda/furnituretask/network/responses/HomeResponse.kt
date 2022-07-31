package com.huda.furnituretask.network.responses

import com.google.gson.annotations.SerializedName
import com.huda.furnituretask.network.model.HomeDto

data class HomeResponse(
    @SerializedName("data")
    var data: HomeDto? = null,
    @SerializedName("message")
    var message: String = "لا يوجد نتائج",
    @SerializedName("status")
    var status: Boolean = false
)