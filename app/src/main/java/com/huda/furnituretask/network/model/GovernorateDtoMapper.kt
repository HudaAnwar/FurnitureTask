package com.huda.furnituretask.network.model

import android.provider.ContactsContract
import com.huda.furnituretask.domain.model.FurnitureCategory
import com.huda.furnituretask.domain.model.FurnitureImage
import com.huda.furnituretask.domain.model.Governorate
import com.huda.furnituretask.domain.model.Product
import com.huda.furnituretask.domain.util.DomainMapper
import javax.inject.Inject


class GovernorateDtoMapper : DomainMapper<GovernorateDto, Governorate> {

    override fun mapToDomainModel(model: GovernorateDto): Governorate {
        with(model) {
            return Governorate(
                id = id,
                name = name,
                governorateId = governorateId
            )
        }
    }

    override fun mapFromDomainModel(domainModel: Governorate): GovernorateDto {
        with(domainModel) {
            return GovernorateDto(
                id = id,
                name = name,
                governorateId = governorateId
            )
        }
    }

}