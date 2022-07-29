package com.huda.furnituretask.util

import com.huda.furnituretask.R

object Constants {
    val furnitureTypeNames = listOf<FurnitureCategory>(
        FurnitureCategory(R.drawable.ic_chair_alt, "كراسي"),
        FurnitureCategory(R.drawable.ic_sofa, "الأرائك"),
        FurnitureCategory(R.drawable.ic_bed, "سراير"),
        FurnitureCategory(R.drawable.ic_table, "سفرة"),
        FurnitureCategory(R.drawable.ic_kitchen, "مطبخ"),
        FurnitureCategory(R.drawable.ic_chair_alt, "كراسي"),
        FurnitureCategory(R.drawable.ic_sofa, "الأرائك"),
        FurnitureCategory(R.drawable.ic_bed, "سراير"),
        FurnitureCategory(R.drawable.ic_chair_alt, "كراسي"),
        FurnitureCategory(R.drawable.ic_sofa, "الأرائك"),
        FurnitureCategory(R.drawable.ic_bed, "سراير"),
        FurnitureCategory(R.drawable.ic_table, "سفرة"),
        FurnitureCategory(R.drawable.ic_kitchen, "مطبخ"),
        FurnitureCategory(R.drawable.ic_chair_alt, "كراسي"),
        FurnitureCategory(R.drawable.ic_sofa, "الأرائك"),
        FurnitureCategory(R.drawable.ic_bed, "سراير"),
    )
}

data class FurnitureCategory(var categoryImage: Int, var categoryName: String)