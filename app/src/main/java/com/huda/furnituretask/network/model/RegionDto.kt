package com.example.example

import com.google.gson.annotations.SerializedName


data class RegionDto (

  @SerializedName("id"        ) var id       : Int?    = null,
  @SerializedName("region_id" ) var regionId : Int?    = null,
  @SerializedName("name"      ) var name     : String? = null

)