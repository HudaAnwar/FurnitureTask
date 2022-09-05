package com.huda.furnituretask.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class BranchTypeDetails(

    var id: Int? = null,
    var branchId: Int? = null,
    var name: String? = null,
    var address: String? = null,
    var phone: String? = null,
    var email: String? = null,
    var timesOfWeek: ArrayList<TimesOfWeek>? = null

) : Parcelable