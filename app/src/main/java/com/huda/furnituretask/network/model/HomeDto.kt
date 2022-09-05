package com.huda.furnituretask.network.model

import com.google.gson.annotations.SerializedName

data class HomeDto(
    @SerializedName("categories") var categories: ArrayList<FurnitureCategoryDto> = arrayListOf(),
    @SerializedName("offers") var offers: ArrayList<OfferDto> = arrayListOf(),
    @SerializedName("saves") var saves: ArrayList<SafeDto> = arrayListOf(),
    @SerializedName("discounts") var discounts: ArrayList<DiscountDto> = arrayListOf(),
    @SerializedName("branch_type") var branchTypeDto: ArrayList<BranchTypeDto> = arrayListOf()
)

