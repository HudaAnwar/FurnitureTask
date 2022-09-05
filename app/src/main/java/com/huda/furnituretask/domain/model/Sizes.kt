package com.huda.furnituretask.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Sizes (

   var id     : Int?    = null,
   var sizeId : Int?    = null,
   var price  : Int?    = null,
   var name   : String? = null

):Parcelable