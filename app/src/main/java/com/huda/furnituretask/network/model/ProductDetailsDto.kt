package com.huda.furnituretask.network.model

import com.google.gson.annotations.SerializedName


data class ProductDetailsDto (

    @SerializedName("id"          ) var id          : Int?              = null,
    @SerializedName("product_id"  ) var productId   : Int?              = null,
    @SerializedName("name"        ) var name        : String?           = null,
    @SerializedName("description" ) var description : String?           = null,
    @SerializedName("price"       ) var price       : Int?              = null,
    @SerializedName("video"       ) var video       : String?           = null,
    @SerializedName("icon"        ) var icon        : String?           = null,
    @SerializedName("images"      ) var images      : ArrayList<ImageDto> = arrayListOf(),
    @SerializedName("sizes"       ) var sizes       : ArrayList<SizesDto>  = arrayListOf(),
    @SerializedName("colors"      ) var colors      : ArrayList<ColorsDto> = arrayListOf(),
    @SerializedName("is_fav"      ) var isFav       : Boolean?          = null,
    @SerializedName("Rate"        ) var rate        : Int?              = null,
    @SerializedName("rate_count"  ) var rateCount   : Int?              = null,
    @SerializedName("model_type"  ) var modelType   : String?           = null,
    @SerializedName("qty_cart"    ) var qtyCart     : String?           = null

)