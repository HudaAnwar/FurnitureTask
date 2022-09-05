package com.huda.furnituretask.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class FurnitureImage(
    var id: Int? = null,
    var pathId: Int? = null,
    var path: String? = null
) : Parcelable