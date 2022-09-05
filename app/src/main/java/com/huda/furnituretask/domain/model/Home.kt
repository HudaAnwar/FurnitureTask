package com.huda.furnituretask.domain.model

data class Home(
    var categories: ArrayList<FurnitureCategory> = arrayListOf(),
    var offers: ArrayList<Offer> = arrayListOf(),
    var saves: ArrayList<Safe> = arrayListOf(),
    var discounts: ArrayList<Discount> = arrayListOf(),
    var branchType: ArrayList<BranchType> = arrayListOf()
)

