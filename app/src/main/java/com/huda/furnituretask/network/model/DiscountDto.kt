package com.huda.furnituretask.network.model

import com.google.gson.annotations.SerializedName

data class DiscountDto(
    @SerializedName("id") var id: Int? = null,
    @SerializedName("discount_id") var discountId: Int? = null,
    @SerializedName("price_before") var priceBefore: Int? = null,
    @SerializedName("price_after") var priceAfter: Int? = null,
    @SerializedName("percent") var percent: Int? = null,
    @SerializedName("product_name") var productName: String? = null,
    @SerializedName("product_description") var productDescription: String? = null,
    @SerializedName("images") var images: ArrayList<ImageDto> = arrayListOf(),
    @SerializedName("furniture_id") var furnitureId: Int? = null,
    @SerializedName("furniture_name") var furnitureName: String? = null,
    @SerializedName("furniture_logo") var furnitureLogo: String? = null,
    @SerializedName("Rate") var rate: Int? = null,
    @SerializedName("rate_count") var rateCount: Int? = null,
    @SerializedName("model_type") var modelType: String? = null,
    @SerializedName("qty_cart") var qtyCart: String? = null
)