package com.huda.furnituretask.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Furniture (

    var id              : Int?                   = null,
    var furnitureId     : Int?                   = null,
    var favouritedCount : Int?                   = null,
    var name            : String?                = null,
    var description     : String?                = null,
    var logo            : String?                = null,
    var phone           : String?                = null,
    var email           : String?                = null,
    var country         : Country?               = Country(),
    var governorate     : Governorate?           = Governorate(),
    var region          : RegionDomain?                = RegionDomain(),
    var address         : String?                = null,
    var branchTypeDetails      : BranchTypeDetails?            = BranchTypeDetails(),
    var timesOfWeek     : ArrayList<TimesOfWeek> = arrayListOf(),
    var isFav           : Boolean?               = null,
    var rate            : Int?                   = null,
    var rateCount       : Int?                   = null,
    var open            : Boolean?               = null,
    var linkGooglePlay  : String?                = null,
    var linkAppleStore  : String?                = null,
    var qrImage         : String?                = null,
    var lat             : String?                = null,
    var lng             : String?                = null

):Parcelable