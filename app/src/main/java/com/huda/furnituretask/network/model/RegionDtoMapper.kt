package com.huda.furnituretask.network.model

import com.example.example.RegionDto
import com.huda.furnituretask.domain.model.RegionDomain
import com.huda.furnituretask.domain.util.DomainMapper


class RegionDtoMapper : DomainMapper<RegionDto, RegionDomain> {

    override fun mapToDomainModel(model: RegionDto): RegionDomain {
        with(model) {
            return RegionDomain(
                id = id,
                name = name,
                regionId = regionId
            )
        }
    }

    override fun mapFromDomainModel(domainModel: RegionDomain): RegionDto {
        with(domainModel) {
            return RegionDto(
                id = id,
                name = name,
                regionId = regionId
            )
        }
    }

}