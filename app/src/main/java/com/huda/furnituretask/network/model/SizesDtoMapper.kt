package com.huda.furnituretask.network.model

import com.huda.furnituretask.domain.model.Sizes
import com.huda.furnituretask.domain.util.DomainMapper

class SizesDtoMapper : DomainMapper<SizesDto, Sizes> {
    override fun mapToDomainModel(model: SizesDto): Sizes {
        with(model) {
            return Sizes(
               id, sizeId, price, name
            )
        }
    }

    override fun mapFromDomainModel(domainModel: Sizes): SizesDto {
        with(domainModel) {
            return SizesDto(
                id, sizeId, price, name
            )
        }
    }

}