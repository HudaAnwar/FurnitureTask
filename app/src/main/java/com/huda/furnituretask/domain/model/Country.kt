package com.huda.furnituretask.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Country(
    var id: Int? = null,
    var countryId: Int? = null,
    var countryCode: String? = null,
    var flag: String? = null,
    var name: String? = null
) : Parcelable