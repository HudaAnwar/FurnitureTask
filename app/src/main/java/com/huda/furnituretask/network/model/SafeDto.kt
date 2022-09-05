package com.huda.furnituretask.network.model

import com.google.gson.annotations.SerializedName

data class SafeDto(
    @SerializedName("id") var id: Int? = null,
    @SerializedName("save_id") var saveId: Int? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("price") var price: Int? = null,
    @SerializedName("video") var video: String? = null,
    @SerializedName("start") var start: String? = null,
    @SerializedName("end") var end: String? = null,
    @SerializedName("diff_day") var diffDay: Int? = null,
    @SerializedName("from") var from: String? = null,
    @SerializedName("to") var to: String? = null,
    @SerializedName("hours") var hours: Int? = null,
    @SerializedName("minutes") var minutes: Int? = null,
    @SerializedName("images") var images: ArrayList<ImageDto> = arrayListOf(),
    @SerializedName("furniture_id") var furnitureId: Int? = null,
    @SerializedName("furniture_name") var furnitureName: String? = null,
    @SerializedName("furniture_logo") var furnitureLogo: String? = null,
    @SerializedName("products") var products: ArrayList<ProductDto> = arrayListOf(),
    @SerializedName("Rate") var rate: Int? = null,
    @SerializedName("rate_count") var rateCount: Int? = null,
    @SerializedName("model_type") var modelType: String? = null,
    @SerializedName("qty_cart") var qtyCart: String? = null
)