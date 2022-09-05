package com.huda.furnituretask.network.model

import com.google.gson.annotations.SerializedName


data class SizesDto (

  @SerializedName("id"      ) var id     : Int?    = null,
  @SerializedName("size_id" ) var sizeId : Int?    = null,
  @SerializedName("price"   ) var price  : Int?    = null,
  @SerializedName("name"    ) var name   : String? = null

)