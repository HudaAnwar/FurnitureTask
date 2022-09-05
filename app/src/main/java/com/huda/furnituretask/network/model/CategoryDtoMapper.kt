package com.huda.furnituretask.network.model

import com.huda.furnituretask.domain.model.FurnitureCategory
import com.huda.furnituretask.domain.util.DomainMapper

class CategoryDtoMapper : DomainMapper<FurnitureCategoryDto, FurnitureCategory> {
    override fun mapToDomainModel(model: FurnitureCategoryDto): FurnitureCategory {
        with(model) {
            return FurnitureCategory(
                categoryId = categoryId,
                id = id,
                code = code,
                image = image,
                name = name,
                count = count
            )
        }
    }

    override fun mapFromDomainModel(domainModel: FurnitureCategory): FurnitureCategoryDto {
        with(domainModel) {
            return FurnitureCategoryDto(
                categoryId = categoryId,
                id = id,
                code = code,
                image = image,
                name = name,
                count = count
            )
        }
    }

}