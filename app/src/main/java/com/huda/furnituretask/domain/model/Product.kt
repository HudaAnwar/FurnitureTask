package com.huda.furnituretask.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Product(
    var productId: Int? = null,
    var quantity: Int? = null,
    var product: String? = null,
    var icon: String? = null
) : Parcelable