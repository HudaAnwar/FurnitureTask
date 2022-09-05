package com.huda.furnituretask.network.responses

import com.google.gson.annotations.SerializedName
import com.huda.furnituretask.network.model.GalleryDto

data class GalleryResponse(
    @SerializedName("data") var data: ArrayList<GalleryDto> = arrayListOf(),
    @SerializedName("message") var message: String? = null,
    @SerializedName("status") var status: Boolean? = null,
    @SerializedName("paginator") var paginator: Paginator? = Paginator()
)

