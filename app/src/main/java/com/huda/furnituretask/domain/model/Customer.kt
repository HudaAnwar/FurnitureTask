package com.huda.furnituretask.domain.model

data class Customer(
    var name: String?="",
    var email: String?="",
    var phone: String?="",
    var avatar: String?=null,
    var address: String?="",
    var gender: String?=null,
    var birthday: String?=null,
    var age:String?="0",
    var id: Int=0,
    var userId:Int=0,
    var token:String?=""
)