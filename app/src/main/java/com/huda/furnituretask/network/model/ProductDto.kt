package com.huda.furnituretask.network.model

import com.google.gson.annotations.SerializedName

data class ProductDto(
    @SerializedName("product_id") var productId: Int? = null,
    @SerializedName("quantity") var quantity: Int? = null,
    @SerializedName("product") var product: String? = null,
    @SerializedName("icon") var icon: String? = null
)