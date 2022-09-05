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
                birthday = birthday,
                gender = gender,
                phone = phone,
                avatar = avatar,
                token = token,
                age = age,
                id = id,
                userId = userId,
            )
        }
    }

    override fun mapFromDomainModel(domainModel: Customer): CustomerDto {
        with(domainModel) {
            return CustomerDto(
                name = name,
                email = email,
                address = address,
                birthday = birthday,
                gender = gender,
                phone = phone,
                avatar = avatar,
                token = token,
                age = age,
                id = id,
                userId = userId,
            )
        }
    }
}