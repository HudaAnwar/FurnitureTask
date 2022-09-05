package com.huda.furnituretask.network.model

import com.huda.furnituretask.domain.model.Colors
import com.huda.furnituretask.domain.model.FurnitureImage
import com.huda.furnituretask.domain.model.ProductDetails
import com.huda.furnituretask.domain.model.Sizes
import com.huda.furnituretask.domain.util.DomainMapper

class ProductDetailsDtoMapper constructor(
    private val imageDtoMapper: ImageDtoMapper,
    private val colorsDtoMapper: ColorsDtoMapper,
    private val sizesDtoMapper: SizesDtoMapper
) : DomainMapper<ProductDetailsDto, ProductDetails> {
    override fun mapToDomainModel(model: ProductDetailsDto): ProductDetails {
        with(model) {
            return ProductDetails(
                productId = productId,
                icon = icon,
                name = name,
                rateCount = rateCount,
                id = id,
                description = description,
                isFav = isFav,
                rate = rate,
                modelType = modelType,
                qtyCart = qtyCart,
                video = video,
                price = price,
                images = imageDtoMapper.toDomainList(images) as ArrayList<FurnitureImage>,
                colors = colorsDtoMapper.toDomainList(colors) as ArrayList<Colors>,
                sizes = sizesDtoMapper.toDomainList(sizes) as ArrayList<Sizes>
            )
        }
    }

    override fun mapFromDomainModel(domainModel: ProductDetails): ProductDetailsDto {
        with(domainModel) {
            return ProductDetailsDto(
                productId = productId,
                icon = icon,
                name = name,
                rateCount = rateCount,
                id = id,
                description = description,
                isFav = isFav,
                rate = rate,
                modelType = modelType,
                qtyCart = qtyCart,
                video = video,
                price = price,
                images = imageDtoMapper.fromDomainList(images) as ArrayList<ImageDto>,
                colors = colorsDtoMapper.fromDomainList(colors) as ArrayList<ColorsDto>,
                sizes = sizesDtoMapper.fromDomainList(sizes) as ArrayList<SizesDto>
            )
        }
    }

}