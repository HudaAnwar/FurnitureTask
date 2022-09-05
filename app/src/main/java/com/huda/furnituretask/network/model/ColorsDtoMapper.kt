package com.huda.furnituretask.network.model

import com.huda.furnituretask.domain.model.Colors
import com.huda.furnituretask.domain.util.DomainMapper

class ColorsDtoMapper : DomainMapper<ColorsDto, Colors> {
    override fun mapToDomainModel(model: ColorsDto): Colors {
        with(model) {
            return Colors(
                id, colorId, code, name
            )
        }
    }

    override fun mapFromDomainModel(domainModel: Colors): ColorsDto {
        with(domainModel) {
            return ColorsDto(
              id, colorId, code, name
            )
        }
    }

}