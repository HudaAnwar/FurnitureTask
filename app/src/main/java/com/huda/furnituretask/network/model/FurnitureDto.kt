package com.huda.furnituretask.network.model

import com.example.example.RegionDto
import com.google.gson.annotations.SerializedName


data class FurnitureDto (

    @SerializedName("id"               ) var id              : Int?                   = null,
    @SerializedName("furniture_id"     ) var furnitureId     : Int?                   = null,
    @SerializedName("favourited_count" ) var favouritedCount : Int?                   = null,
    @SerializedName("name"             ) var name            : String?                = null,
    @SerializedName("description"      ) var description     : String?                = null,
    @SerializedName("logo"             ) var logo            : String?                = null,
    @SerializedName("phone"            ) var phone           : String?                = null,
    @SerializedName("email"            ) var email           : String?                = null,
    @SerializedName("country"          ) var country         : CountryDto?               = CountryDto(),
    @SerializedName("governorate"      ) var governorate     : GovernorateDto?           = GovernorateDto(),
    @SerializedName("region"           ) var region          : RegionDto?                = RegionDto(),
    @SerializedName("address"          ) var address         : String?                = null,
    @SerializedName("branchType"       ) var branchTypeDetails    : BranchTypeDetailsDto?            = BranchTypeDetailsDto(),
    @SerializedName("times_of_week"    ) var timesOfWeek     : ArrayList<TimesOfWeekDto> = arrayListOf(),
    @SerializedName("is_fav"           ) var isFav           : Boolean?               = null,
    @SerializedName("Rate"             ) var rate            : Int?                   = null,
    @SerializedName("rate_count"       ) var rateCount       : Int?                   = null,
    @SerializedName("open"             ) var open            : Boolean?               = null,
    @SerializedName("link_google_play" ) var linkGooglePlay  : String?                = null,
    @SerializedName("link_apple_store" ) var linkAppleStore  : String?                = null,
    @SerializedName("qr_image"         ) var qrImage         : String?                = null,
    @SerializedName("lat"              ) var lat             : String?                = null,
    @SerializedName("lng"              ) var lng             : String?                = null

)