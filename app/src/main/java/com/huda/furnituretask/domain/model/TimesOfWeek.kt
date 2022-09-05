package com.huda.furnituretask.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TimesOfWeek(

    var day: String? = null,
    var from: String? = null,
    var to: String? = null

) : Parcelable