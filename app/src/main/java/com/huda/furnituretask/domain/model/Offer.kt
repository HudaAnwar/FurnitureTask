package com.huda.furnituretask.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Offer(
    var id: Int? = null,
    var offerId: Int? = null,
    var name: String? = null,
    var price: Int? = null,
    var video: String? = null,
    var images: ArrayList<FurnitureImage> = arrayListOf(),
    var furnitureId: Int? = null,
    var furnitureName: String? = null,
    var furnitureLogo: String? = null,
    var products: ArrayList<Product> = arrayListOf(),
    var rate: Int? = null,
    var rateCount: Int? = null,
    var modelType: String? = null,
    var qtyCart: String? = null
):Parcelable