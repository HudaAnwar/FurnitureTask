package com.huda.furnituretask.network.model

import com.google.gson.annotations.SerializedName

data class CategoryDto(
    @SerializedName("id")
    var id: Int,
    @SerializedName("category_id")
    var categoryId: Int,
    @SerializedName("code")
    var code: String,
    @SerializedName("image")
    var image: String,
    @SerializedName("name")
    var name: String,
    @SerializedName("count")
    var count : Int
)