package com.huda.furnituretask.network.model

import android.provider.ContactsContract
import com.huda.furnituretask.domain.model.FurnitureCategory
import com.huda.furnituretask.domain.model.FurnitureImage
import com.huda.furnituretask.domain.model.Country
import com.huda.furnituretask.domain.model.Product
import com.huda.furnituretask.domain.util.DomainMapper
import javax.inject.Inject


class CountryDtoMapper : DomainMapper<CountryDto, Country> {

    override fun mapToDomainModel(model: CountryDto): Country {
        with(model) {
            return Country(
                id = id,
                name = name,
                countryCode = countryCode,
                countryId = countryId,
                flag = flag,
            )
        }
    }

    override fun mapFromDomainModel(domainModel: Country): CountryDto {
        with(domainModel) {
            return CountryDto(
                id = id,
                name = name,
                countryCode = countryCode,
                countryId = countryId,
                flag = flag,
            )
        }
    }

}