package com.huda.furnituretask.network.model

import com.huda.furnituretask.domain.model.Product
import com.huda.furnituretask.domain.util.DomainMapper

class ProductDtoMapper : DomainMapper<ProductDto, Product> {
    override fun mapToDomainModel(model: ProductDto): Product {
        with(model) {
            return Product(
                productId = productId,
                product = product,
                icon = icon,
                quantity = quantity
            )
        }
    }

    override fun mapFromDomainModel(domainModel: Product): ProductDto {
        with(domainModel) {
            return ProductDto(
                productId = productId,
                product = product,
                icon = icon,
                quantity = quantity
            )
        }
    }

}