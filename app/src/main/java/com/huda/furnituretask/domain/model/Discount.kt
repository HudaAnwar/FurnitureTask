package com.huda.furnituretask.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Discount(
    var id: Int? = null,
    var discountId: Int? = null,
    var priceBefore: Int? = null,
    var priceAfter: Int? = null,
    var percent: Int? = null,
    var productName: String? = null,
    var productDescription: String? = null,
    var images: ArrayList<FurnitureImage> = arrayListOf(),
    var furnitureId: Int? = null,
    var furnitureName: String? = null,
    var furnitureLogo: String? = null,
    var rate: Int? = null,
    var rateCount: Int? = null,
    var modelType: String? = null,
    var qtyCart: String? = null
) : Parcelable