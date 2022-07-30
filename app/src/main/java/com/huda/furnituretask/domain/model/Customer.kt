package com.huda.furnituretask.domain.model

data class Customer(
    var name: String,
    var email: String,
    var phone: String,
    var password: String,
    var passwordConfirmation: String,
    var language: String,
    var address: String,
    var avatar: String,
    var countryId: Int,
    var governorateId: Int,
//region_id:13
    var birthday: String,//1994-08-18
    var gender: String//male
)