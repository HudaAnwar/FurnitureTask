package com.example.example

import com.google.gson.annotations.SerializedName
import com.huda.furnituretask.network.model.OfferDto
import com.huda.furnituretask.network.responses.Paginator


data class OfferResponse (

  @SerializedName("data"      ) var data      : ArrayList<OfferDto> = arrayListOf(),
  @SerializedName("message"   ) var message   : String?         = null,
  @SerializedName("status"    ) var status    : Boolean?        = null,
  @SerializedName("paginator" ) var paginator : Paginator?      = Paginator()

)