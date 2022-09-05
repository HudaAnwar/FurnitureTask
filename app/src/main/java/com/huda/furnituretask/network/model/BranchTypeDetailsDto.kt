package com.huda.furnituretask.network.model

import com.google.gson.annotations.SerializedName
import com.huda.furnituretask.domain.model.TimesOfWeek


data class BranchTypeDetailsDto (

  @SerializedName("id"            ) var id          : Int?    = null,
  @SerializedName("branch_id"     ) var branchId    : Int?    = null,
  @SerializedName("name"          ) var name        : String? = null,
  @SerializedName("address"       ) var address     : String? = null,
  @SerializedName("phone"         ) var phone       : String? = null,
  @SerializedName("email"         ) var email       : String? = null,
  @SerializedName("times_of_week" ) var timesOfWeek : ArrayList<TimesOfWeekDto>? = null

)