package com.huda.furnituretask.network.model

import com.google.gson.annotations.SerializedName


data class GalleryDetailsDto(

    @SerializedName("furniture") var furniture: FurnitureDto? = FurnitureDto(),
    @SerializedName("most_wanted_products") var mostWantedProducts: ArrayList<ProductDetailsDto> = arrayListOf(),
    @SerializedName("menu") var menu: ArrayList<MenuDto> = arrayListOf(),
    @SerializedName("offers") var offers: ArrayList<OfferDto> = arrayListOf(),
    @SerializedName("saves") var saves: ArrayList<SafeDto> = arrayListOf(),
    @SerializedName("discounts") var discounts: ArrayList<DiscountDto> = arrayListOf(),
    @SerializedName("extras") var extras: ArrayList<String> = arrayListOf(),
    @SerializedName("branches") var branches: ArrayList<BranchTypeDetailsDto> = arrayListOf(),
    @SerializedName("favourites") var favourites: ArrayList<String> = arrayListOf(),
    @SerializedName("rates") var rates: ArrayList<String> = arrayListOf()

)