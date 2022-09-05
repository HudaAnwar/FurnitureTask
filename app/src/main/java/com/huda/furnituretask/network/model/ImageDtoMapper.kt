package com.huda.furnituretask.network.model

import com.huda.furnituretask.domain.model.FurnitureCategory
import com.huda.furnituretask.domain.model.FurnitureImage
import com.huda.furnituretask.domain.model.Offer
import com.huda.furnituretask.domain.util.DomainMapper

class ImageDtoMapper : DomainMapper<ImageDto, FurnitureImage> {
    override fun mapToDomainModel(model: ImageDto): FurnitureImage {
        with(model) {
            return FurnitureImage(
                id = id,
                pathId = pathId,
                path = path
            )
        }
    }

    override fun mapFromDomainModel(domainModel: FurnitureImage): ImageDto {
        with(domainModel) {
            return ImageDto(
                id = id,
                pathId = pathId,
                path = path
            )
        }
    }

}