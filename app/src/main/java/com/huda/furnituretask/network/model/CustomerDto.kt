package com.huda.furnituretask.network.model

import com.google.gson.annotations.SerializedName

data class CustomerDto(
    @SerializedName("name")
    var name: String,
    @SerializedName("email")
    var email: String,
    @SerializedName("phone")
    var phone: String,
    @SerializedName("password")
    var password: String,
    @SerializedName("password_confirmation")
    var passwordConfirmation: String,
    @SerializedName("lang")
    var language: String,
    @SerializedName("address")
    var address: String,
    @SerializedName("avatar")
    var avatar: String="",
    @SerializedName("country_code")
    var countryCode: String,
//region_id:13
    @SerializedName("birthday")
    var birthday: String,//1994-08-18
    @SerializedName("gender")
    var gender: String,//male
    @SerializedName("age")
    var age: String="",
    @SerializedName("id")
    var id: Int=0,
    @SerializedName("user_id")
    var userId: Int=0,
    @SerializedName("token")
    var token: String=""
)
