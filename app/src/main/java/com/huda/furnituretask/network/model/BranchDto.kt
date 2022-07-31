package com.huda.furnituretask.network.model

import com.google.gson.annotations.SerializedName

data class BranchDto(
    @SerializedName("id")
    var id: Int,
    @SerializedName("branch_type_id")
    var branchTypeId: Int,
    @SerializedName("image")
    var image: String,
    @SerializedName("name")
    var name: String,
    @SerializedName("count")
    var count: Int
)