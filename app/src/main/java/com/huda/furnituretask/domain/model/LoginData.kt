package com.huda.furnituretask.domain.model

data class LoginData(
    var isSuccessful:Boolean,
    var message:String,
    var customer: Customer?
)
