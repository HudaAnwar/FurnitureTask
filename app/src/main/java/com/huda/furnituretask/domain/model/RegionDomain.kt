package com.huda.furnituretask.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RegionDomain(
    var id: Int? = null,
    var regionId: Int? = null,
    var name: String? = null
) : Parcelable