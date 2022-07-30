package com.huda.furnituretask.network.model

import com.huda.furnituretask.domain.model.Customer
import com.huda.furnituretask.domain.util.DomainMapper

class CustomerDtoMapper : DomainMapper<CustomerDto, Customer> {
    override fun mapToDomainModel(model: CustomerDto): Customer {
        with(model) {
            return Customer(
                name = name,
                email = email,
                address = address,
                avatar = avatar,
                birthday = birthday,
                countryId = countryId,
                gender = gender,
                governorateId = governorateId,
                language = language,
                password = password,
                passwordConfirmation = passwordConfirmation,
                phone = phone
            )
        }
    }

    override fun mapFromDomainModel(domainModel: Customer): CustomerDto {
        with(domainModel) {
            return CustomerDto(
                name = name,
                email = email,
                address = address,
                avatar = avatar,
                birthday = birthday,
                countryId = countryId,
                gender = gender,
                governorateId = governorateId,
                language = language,
                password = password,
                passwordConfirmation = passwordConfirmation,
                phone = phone
            )
        }
    }

}