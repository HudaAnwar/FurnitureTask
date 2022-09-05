package com.huda.furnituretask.network.model

import com.huda.furnituretask.domain.model.*
import com.huda.furnituretask.domain.util.DomainMapper
import javax.inject.Inject

class FurnitureDtoMapper @Inject constructor(
    private val countryDtoMapper: CountryDtoMapper,
    private val governorateDtoMapper: GovernorateDtoMapper,
    private val regionDtoMapper: RegionDtoMapper,
    private val branchTypeDetailsDtoMapper: BranchTypeDetailsDtoMapper,
    private val timesOfWeekDtoMapper: TimesOfWeekDtoMapper
) : DomainMapper<FurnitureDto, Furniture> {
    override fun mapToDomainModel(model: FurnitureDto): Furniture {

        with(model) {
            return Furniture(
                furnitureId = furnitureId,
                timesOfWeek = timesOfWeekDtoMapper.toDomainList(timesOfWeek) as ArrayList<TimesOfWeek>,
                email = email,
                phone = phone,
                address = address,
                region = region?.let { regionDtoMapper.mapToDomainModel(it) },
                rate = rate,
                qrImage = qrImage,
                open = open,
                logo = logo,
                lng = lng,
                linkGooglePlay = linkGooglePlay,
                linkAppleStore = linkAppleStore,
                lat = lat,
                isFav = isFav,
                governorate = governorate?.let { governorateDtoMapper.mapToDomainModel(it) },
                country = country?.let { countryDtoMapper.mapToDomainModel(it) },
                description = description,
                id = id,
                name = name,
                rateCount = rateCount,
                branchTypeDetails = branchTypeDetails?.let {
                    branchTypeDetailsDtoMapper.mapToDomainModel(
                        it
                    )
                },
                favouritedCount = favouritedCount,
            )
        }
    }

    override fun mapFromDomainModel(domainModel: Furniture): FurnitureDto {
        with(domainModel) {
            return FurnitureDto(
                furnitureId = furnitureId,
                timesOfWeek = timesOfWeekDtoMapper.fromDomainList(timesOfWeek) as ArrayList<TimesOfWeekDto>,
                email = email,
                phone = phone,
                address = address,
                region = region?.let { regionDtoMapper.mapFromDomainModel(it) },
                rate = rate,
                qrImage = qrImage,
                open = open,
                logo = logo,
                lng = lng,
                linkGooglePlay = linkGooglePlay,
                linkAppleStore = linkAppleStore,
                lat = lat,
                isFav = isFav,
                governorate = governorate?.let { governorateDtoMapper.mapFromDomainModel(it) },
                country = country?.let { countryDtoMapper.mapFromDomainModel(it) },
                description = description,
                id = id,
                name = name,
                rateCount = rateCount,
                branchTypeDetails = branchTypeDetails?.let {
                    branchTypeDetailsDtoMapper.mapFromDomainModel(
                        it
                    )
                },
                favouritedCount = favouritedCount,

                )
        }
    }

}