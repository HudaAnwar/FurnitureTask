package com.huda.furnituretask.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Governorate(
    var id: Int? = null,
    var governorateId: Int? = null,
    var name: String? = null
) : Parcelable