package com.huda.furnituretask.network.model

import com.google.gson.annotations.SerializedName

data class HomeDto(
    @SerializedName("categories")
    var categories: List<CategoryDto>,
    @SerializedName("offers")
    var offers: List<String>,
    @SerializedName("saves")
    var saves: List<String>,
    @SerializedName("discounts")
    var discounts: List<String>,
    @SerializedName("branch_type")
    var branchType: List<BranchDto>
)