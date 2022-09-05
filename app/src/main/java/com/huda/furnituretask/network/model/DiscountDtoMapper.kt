package com.huda.furnituretask.network.model

import com.huda.furnituretask.domain.model.Discount
import com.huda.furnituretask.domain.model.FurnitureImage
import com.huda.furnituretask.domain.util.DomainMapper
import javax.inject.Inject


class DiscountDtoMapper @Inject constructor(
    private val imageDtoMapper: ImageDtoMapper
) : DomainMapper<DiscountDto, Discount> {

    override fun mapToDomainModel(model: DiscountDto): Discount {
        with(model) {
            return Discount(
                id = id,
                images = imageDtoMapper.toDomainList(images) as ArrayList<FurnitureImage>,
                rate = rate,
                furnitureId = furnitureId,
                rateCount = rateCount,
                qtyCart = qtyCart,
                modelType = modelType,
                furnitureName = furnitureName,
                furnitureLogo = furnitureLogo,
                discountId = discountId,
                percent = percent,
                priceAfter = priceAfter,
                priceBefore = priceBefore,
                productDescription = productDescription,
                productName = productName
            )
        }
    }

    override fun mapFromDomainModel(domainModel: Discount): DiscountDto {
        with(domainModel) {
            return DiscountDto(
                id = id,
                images = imageDtoMapper.fromDomainList(images) as ArrayList<ImageDto>,
                rate = rate,
                furnitureId = furnitureId,
                rateCount = rateCount,
                qtyCart = qtyCart,
                modelType = modelType,
                furnitureName = furnitureName,
                furnitureLogo = furnitureLogo,
                discountId = discountId,
                percent = percent,
                priceAfter = priceAfter,
                priceBefore = priceBefore,
                productDescription = productDescription,
                productName = productName
            )
        }
    }

}