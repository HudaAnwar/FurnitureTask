package com.huda.furnituretask.network.responses

import com.google.gson.annotations.SerializedName

data class Paginator(
    @SerializedName("total") var total: Int? = null,
    @SerializedName("count") var count: Int? = null,
    @SerializedName("currentPage") var currentPage: Int? = null,
    @SerializedName("lastPage") var lastPage: Int? = null,
    @SerializedName("hasMorePages") var hasMorePages: Boolean? = null,
    @SerializedName("nextPageUrl") var nextPageUrl: String? = null,
    @SerializedName("previousPageUrl") var previousPageUrl: String? = null
)