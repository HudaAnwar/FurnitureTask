package com.huda.furnituretask.network.model

import com.google.gson.annotations.SerializedName

data class BranchTypeDto(
    @SerializedName("id") var id: Int? = null,
    @SerializedName("branch_type_id") var branchTypeId: Int? = null,
    @SerializedName("image") var image: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("count") var count: Int? = null
)