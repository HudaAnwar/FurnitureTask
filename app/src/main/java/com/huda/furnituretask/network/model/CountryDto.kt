package com.huda.furnituretask.network.model

import com.google.gson.annotations.SerializedName


data class CountryDto (

  @SerializedName("id"           ) var id          : Int?    = null,
  @SerializedName("country_id"   ) var countryId   : Int?    = null,
  @SerializedName("country_code" ) var countryCode : String? = null,
  @SerializedName("flag"         ) var flag        : String? = null,
  @SerializedName("name"         ) var name        : String? = null

)