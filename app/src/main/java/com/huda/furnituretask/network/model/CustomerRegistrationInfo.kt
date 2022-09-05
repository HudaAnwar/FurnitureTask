package com.huda.furnituretask.network.model

import com.google.gson.annotations.SerializedName

data class CustomerRegistrationInfo(
    var name: String? = null,
    var email: String? = null,
    var phone: String? = null,
    var password: String? = null,
    var password_confirmation: String? = null,
    var address: String? = null,
    var country_code: String? = null
)
