package com.huda.furnituretask.network.model

import com.google.gson.annotations.SerializedName


data class CustomerDto(
    @SerializedName("name")
    var name: String?="",
    @SerializedName("email")
    var email: String?="",
    @SerializedName("phone")
    var phone: String?="",
    @SerializedName("avatar")
    var avatar: String?=null,
    @SerializedName("address")
    var address: String?="",
    @SerializedName("gender")
    var gender: String?=null,
    @SerializedName("birthday")
    var birthday: String?=null,
    @SerializedName("age")
    var age:String?="0",
    @SerializedName("id")
    var id: Int=0,
    @SerializedName("user_id")
    var userId:Int=0,
    @SerializedName("token")
    var token:String?=""
)
