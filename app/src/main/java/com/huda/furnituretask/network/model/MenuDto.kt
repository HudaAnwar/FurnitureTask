package com.huda.furnituretask.network.model

import com.google.gson.annotations.SerializedName


data class MenuDto (

  @SerializedName("id"            ) var id            : Int?                = null,
  @SerializedName("menu_id"       ) var menuId        : Int?                = null,
  @SerializedName("code"          ) var code          : String?             = null,
  @SerializedName("image"         ) var image         : String?             = null,
  @SerializedName("name"          ) var name          : String?             = null,
  @SerializedName("subcategories" ) var subcategories : ArrayList<FurnitureCategoryDto>   = arrayListOf(),
  @SerializedName("products"      ) var products      : ArrayList<ProductDetailsDto> = arrayListOf()

)