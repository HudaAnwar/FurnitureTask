package com.example.example

import com.google.gson.annotations.SerializedName
import com.huda.furnituretask.domain.model.Safe
import com.huda.furnituretask.network.model.OfferDto
import com.huda.furnituretask.network.model.SafeDto
import com.huda.furnituretask.network.responses.Paginator


data class FurnitureResponse<T> (

  @SerializedName("data"      ) var data      : ArrayList<T> = arrayListOf(),
  @SerializedName("message"   ) var message   : String?         = null,
  @SerializedName("status"    ) var status    : Boolean?        = null,
  @SerializedName("paginator" ) var paginator : Paginator?      = Paginator()

)