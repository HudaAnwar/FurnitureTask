package com.huda.furnituretask.network.model

import com.google.gson.annotations.SerializedName


data class ColorsDto (

  @SerializedName("id"       ) var id      : Int?    = null,
  @SerializedName("color_id" ) var colorId : Int?    = null,
  @SerializedName("code"     ) var code    : String? = null,
  @SerializedName("name"     ) var name    : String? = null

)