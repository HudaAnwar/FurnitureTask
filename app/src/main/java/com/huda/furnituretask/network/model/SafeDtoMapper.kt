package com.huda.furnituretask.network.model

import com.huda.furnituretask.domain.model.FurnitureImage
import com.huda.furnituretask.domain.model.Product
import com.huda.furnituretask.domain.model. Safe
import com.huda.furnituretask.domain.util.DomainMapper
import javax.inject.Inject


class SafeDtoMapper @Inject constructor(
    private val imageDtoMapper: ImageDtoMapper,
    private val productDtoMapper: ProductDtoMapper
) : DomainMapper< SafeDto, Safe> {

    override fun mapToDomainModel(model:  SafeDto):  Safe {
        with(model) {
            return  Safe(
                id = id,
                name = name,
                images = images.let { imageDtoMapper.toDomainList(it) } as ArrayList<FurnitureImage>,
                price = price,
                products = products.let { productDtoMapper.toDomainList(it) } as ArrayList<Product>,
                rate = rate,
                video = video,
                diffDay = diffDay,
                end = end,
                from = from,
                furnitureId = furnitureId,
                rateCount = rateCount,
                qtyCart = qtyCart,
                modelType = modelType,
                furnitureName = furnitureName,
                furnitureLogo = furnitureLogo,
                hours = hours,
                minutes = minutes,
                saveId = saveId,
                start = start,
                to= to
            )
        }
    }

    override fun mapFromDomainModel(domainModel:  Safe):  SafeDto {
        with(domainModel) {
            return  SafeDto(
                id = id,
                name = name,
                images = images.let { imageDtoMapper.fromDomainList(it) } as ArrayList<ImageDto>,
                price = price,
                products = products.let { productDtoMapper.fromDomainList(it) } as ArrayList<ProductDto>,
                rate = rate,
                video = video,
                diffDay = diffDay,
                end = end,
                from = from,
                furnitureId = furnitureId,
                rateCount = rateCount,
                qtyCart = qtyCart,
                modelType = modelType,
                furnitureName = furnitureName,
                furnitureLogo = furnitureLogo,
                hours = hours,
                minutes = minutes,
                saveId = saveId,
                start = start,
                to = to
            )
        }
    }

}