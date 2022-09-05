package com.huda.furnituretask.network.model

import com.google.gson.annotations.SerializedName

data class FurnitureCategoryDto(
    @SerializedName("id") var id: Int? = null,
    @SerializedName("category_id") var categoryId: Int? = null,
    @SerializedName("code") var code: String? = null,
    @SerializedName("image") var image: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("count") var count: Int? = null
)