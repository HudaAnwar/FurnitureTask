package com.huda.furnituretask.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Menu (

   var id            : Int?                = null,
   var menuId        : Int?                = null,
   var code          : String?             = null,
   var image         : String?             = null,
   var name          : String?             = null,
   var subcategories : ArrayList<FurnitureCategory>   = arrayListOf(),
   var products      : ArrayList<ProductDetails> = arrayListOf()

):Parcelable