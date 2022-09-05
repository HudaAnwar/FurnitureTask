package com.huda.furnituretask.network.responses

import com.google.gson.annotations.SerializedName
import com.huda.furnituretask.network.model.GalleryDetailsDto


data class GalleryDetailsResponse (

    @SerializedName("data"    ) var data    : GalleryDetailsDto?    = GalleryDetailsDto(),
    @SerializedName("message" ) var message : String?  = null,
    @SerializedName("status"  ) var status  : Boolean? = null

)