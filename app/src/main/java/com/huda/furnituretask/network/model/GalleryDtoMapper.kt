package com.huda.furnituretask.network.model

import com.huda.furnituretask.R
import com.huda.furnituretask.domain.model.*
import com.huda.furnituretask.domain.util.DomainMapper
import javax.inject.Inject

class GalleryDtoMapper @Inject constructor(
    private val countryDtoMapper: CountryDtoMapper,
    private val regionDtoMapper: RegionDtoMapper,
    private val governorateDtoMapper: GovernorateDtoMapper
) : DomainMapper<GalleryDto, Gallery> {
    override fun mapToDomainModel(model: GalleryDto): Gallery {

        with(model) {
            return Gallery(
                branchTypeId = branchTypeId,
                rateCount = rateCount,
                furnitureId = furnitureId,
                address = address,
                name = name,
                id = id,
                description = description,
                branchTypeName = branchTypeName,
                country = country?.let { countryDtoMapper.mapToDomainModel(it) },
                distance = distance,
                governorate = governorate?.let { governorateDtoMapper.mapToDomainModel(it) },
                isFav = isFav,
                lat = lat,
                linkAppleStore = linkAppleStore,
                linkGooglePlay = linkGooglePlay,
                lng = lng,
                logo = logo,
                open = open,
                qrImage = qrImage,
                rate = rate,
                region = region?.let { regionDtoMapper.mapToDomainModel(it) }
            )
        }
    }

    override fun mapFromDomainModel(domainModel: Gallery): GalleryDto {
        with(domainModel) {
            return GalleryDto(
                branchTypeId = branchTypeId,
                rateCount = rateCount,
                furnitureId = furnitureId,
                address = address,
                name = name,
                id = id,
                description = description,
                branchTypeName = branchTypeName,
                country = country?.let { countryDtoMapper.mapFromDomainModel(it) },
                distance = distance,
                governorate = governorate?.let { governorateDtoMapper.mapFromDomainModel(it) },
                isFav = isFav,
                lat = lat,
                linkAppleStore = linkAppleStore,
                linkGooglePlay = linkGooglePlay,
                lng = lng,
                logo = logo,
                open = open,
                qrImage = qrImage,
                rate = rate,
                region = region?.let { regionDtoMapper.mapFromDomainModel(it) }
            )
        }
    }

}