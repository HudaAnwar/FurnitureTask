package com.huda.furnituretask.network.model

import com.google.gson.annotations.SerializedName


data class GovernorateDto (

  @SerializedName("id"             ) var id            : Int?    = null,
  @SerializedName("governorate_id" ) var governorateId : Int?    = null,
  @SerializedName("name"           ) var name          : String? = null

)