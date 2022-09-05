package com.huda.furnituretask.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class FurnitureCategory(
    var id: Int? = null,
    var categoryId: Int? = null,
    var code: String? = null,
    var image: String? = null,
    var name: String? = null,
    var count: Int? = null
):Parcelable