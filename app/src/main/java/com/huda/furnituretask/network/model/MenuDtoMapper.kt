package com.huda.furnituretask.network.model

import com.huda.furnituretask.domain.model.FurnitureCategory
import com.huda.furnituretask.domain.model.Menu
import com.huda.furnituretask.domain.model.ProductDetails
import com.huda.furnituretask.domain.util.DomainMapper
import javax.inject.Inject

class MenuDtoMapper @Inject constructor(
    private val productDetailsDtoMapper: ProductDetailsDtoMapper,
    private val categoryDtoMapper: CategoryDtoMapper
) : DomainMapper<MenuDto, Menu> {
    override fun mapToDomainModel(model: MenuDto): Menu {
        with(model) {
            return Menu(
                id = id,
                menuId = menuId,
                name = name,
                products = productDetailsDtoMapper.toDomainList(products) as ArrayList<ProductDetails>,
                image = image,
                code = code,
                subcategories = categoryDtoMapper.toDomainList(subcategories) as ArrayList<FurnitureCategory>
            )
        }
    }

    override fun mapFromDomainModel(domainModel: Menu): MenuDto {
        with(domainModel) {
            return MenuDto(
                id = id,
                menuId = menuId,
                name = name,
                products = productDetailsDtoMapper.fromDomainList(products) as ArrayList<ProductDetailsDto>,
                image = image,
                code = code,
                subcategories = categoryDtoMapper.fromDomainList(subcategories) as ArrayList<FurnitureCategoryDto>
            )
        }
    }

}