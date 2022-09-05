package com.huda.furnituretask.network.model

import android.provider.ContactsContract
import com.huda.furnituretask.domain.model.FurnitureCategory
import com.huda.furnituretask.domain.model.FurnitureImage
import com.huda.furnituretask.domain.model.Offer
import com.huda.furnituretask.domain.model.Product
import com.huda.furnituretask.domain.util.DomainMapper
import javax.inject.Inject


class OfferDtoMapper @Inject constructor(
    private val imageDtoMapper: ImageDtoMapper,
    private val productDtoMapper: ProductDtoMapper
) : DomainMapper<OfferDto, Offer> {

    override fun mapToDomainModel(model: OfferDto): Offer {
        with(model) {
            return Offer(
                id = id,
                name = name,
                furnitureId = furnitureId,
                furnitureLogo = furnitureLogo,
                furnitureName = furnitureName,
                images = imageDtoMapper.toDomainList(images) as ArrayList<FurnitureImage>,
                modelType = modelType,
                offerId = offerId,
                price = price,
                products = productDtoMapper.toDomainList(products) as ArrayList<Product>,
                qtyCart = qtyCart,
                rate = rate,
                rateCount = rateCount,
                video = video
            )
        }
    }

    override fun mapFromDomainModel(domainModel: Offer): OfferDto {
        with(domainModel) {
            return OfferDto(
                id = id,
                name = name,
                furnitureId = furnitureId,
                furnitureLogo = furnitureLogo,
                furnitureName = furnitureName,
                images = imageDtoMapper.fromDomainList(images) as ArrayList<ImageDto>,
                modelType = modelType,
                offerId = offerId,
                price = price,
                products = productDtoMapper.fromDomainList(products) as ArrayList<ProductDto>,
                qtyCart = qtyCart,
                rate = rate,
                rateCount = rateCount,
                video = video
            )
        }
    }

}