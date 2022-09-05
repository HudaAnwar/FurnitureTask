package com.huda.furnituretask.network.model

import com.google.gson.annotations.SerializedName


data class ImageDto (

  @SerializedName("id"      ) var id     : Int?    = null,
  @SerializedName("path_id" ) var pathId : Int?    = null,
  @SerializedName("path"    ) var path   : String? = null

)