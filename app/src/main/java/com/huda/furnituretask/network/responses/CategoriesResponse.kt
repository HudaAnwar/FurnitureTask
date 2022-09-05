package com.huda.furnituretask.network.responses

import com.google.gson.annotations.SerializedName
import com.huda.furnituretask.network.model.FurnitureCategoryDto

data class CategoriesResponse(
    @SerializedName("data")
    var data: List<FurnitureCategoryDto>? = null,
    @SerializedName("message")
    var message: String = "لا يوجد نتائج",
    @SerializedName("status")
    var status: Boolean = false
)