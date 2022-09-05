package com.huda.furnituretask.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class GalleryDetails(
    var furniture: Furniture? = Furniture(),
    var mostWantedProducts: ArrayList<ProductDetails> = arrayListOf(),
    var menu: ArrayList<Menu> = arrayListOf(),
    var offers: ArrayList<Offer> = arrayListOf(),
    var saves: ArrayList<Safe> = arrayListOf(),
    var discounts: ArrayList<Discount> = arrayListOf(),
    var extras: ArrayList<String> = arrayListOf(),
    var branches: ArrayList<BranchTypeDetails> = arrayListOf(),
    var favourites: ArrayList<String> = arrayListOf(),
    var rates: ArrayList<String> = arrayListOf()
) : Parcelable