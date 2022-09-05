package com.huda.furnituretask.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Colors (

   var id      : Int?    = null,
   var colorId : Int?    = null,
   var code    : String? = null,
   var name    : String? = null

):Parcelable