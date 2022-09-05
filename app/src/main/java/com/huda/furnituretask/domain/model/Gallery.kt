package com.huda.furnituretask.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

data class Gallery(
    var id: Int? = null,
    var furnitureId: Int? = null,
    var branchTypeId: Int? = null,
    var branchTypeName: String? = null,
    var name: String? = null,
    var description: String? = null,
    var logo: String? = null,
    var country: Country? = Country(),
    var governorate: Governorate? = Governorate(),
    var region: RegionDomain? = RegionDomain(),
    var address: String? = null,
    var isFav: Boolean? = null,
    var rate: Int? = null,
    var rateCount: String? = null,
    var open: Boolean? = null,
    var linkGooglePlay: String? = null,
    var linkAppleStore: String? = null,
    var qrImage: String? = null,
    var lat: String? = null,
    var lng: String? = null,
    var distance: Int? = null
)

