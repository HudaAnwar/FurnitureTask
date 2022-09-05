package com.huda.furnituretask.network.model

import com.google.gson.annotations.SerializedName


data class TimesOfWeekDto (

  @SerializedName("day"  ) var day  : String? = null,
  @SerializedName("from" ) var from : String? = null,
  @SerializedName("to"   ) var to   : String? = null

)