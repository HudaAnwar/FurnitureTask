package com.huda.furnituretask.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProductDetails (

    var id          : Int?              = null,
    var productId   : Int?              = null,
    var name        : String?           = null,
    var description : String?           = null,
    var price       : Int?              = null,
    var video       : String?           = null,
    var icon        : String?           = null,
    var images      : ArrayList<FurnitureImage> = arrayListOf(),
    var sizes       : ArrayList<Sizes>  = arrayListOf(),
    var colors      : ArrayList<Colors> = arrayListOf(),
    var isFav       : Boolean?          = null,
    var rate        : Int?              = null,
    var rateCount   : Int?              = null,
    var modelType   : String?           = null,
    var qtyCart     : String?           = null

):Parcelable