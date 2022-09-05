package com.huda.furnituretask.network.model

import com.huda.furnituretask.domain.model.*
import com.huda.furnituretask.domain.util.DomainMapper
import javax.inject.Inject

class HomeDtoMapper @Inject constructor(
    private val branchTypeDtoMapper: BranchTypeDtoMapper,
    private val categoryDtoMapper: CategoryDtoMapper,
    private val offerMapper: OfferDtoMapper,
    private val safeDtoMapper: SafeDtoMapper,
    private val discountDtoMapper: DiscountDtoMapper

) : DomainMapper<HomeDto, Home> {
    override fun mapToDomainModel(model: HomeDto): Home {

        with(model) {
            return Home(
                branchType = branchTypeDtoMapper.toDomainList(branchTypeDto) as ArrayList<BranchType>,
                categories = categoryDtoMapper.toDomainList(categories) as ArrayList<FurnitureCategory>,
                discounts = discountDtoMapper.toDomainList(discounts) as ArrayList<Discount>,
                offers = offerMapper.toDomainList(offers) as ArrayList<Offer>,
                saves = safeDtoMapper.toDomainList(saves) as ArrayList<Safe>
            )
        }
    }

    override fun mapFromDomainModel(domainModel: Home): HomeDto {
        with(domainModel) {
            return HomeDto(
                branchTypeDto = branchTypeDtoMapper.fromDomainList(branchType) as ArrayList<BranchTypeDto>,
                categories = categoryDtoMapper.fromDomainList(categories) as ArrayList<FurnitureCategoryDto>,
                discounts = discountDtoMapper.fromDomainList(discounts) as ArrayList<DiscountDto>,
                offers = offerMapper.fromDomainList(offers) as ArrayList<OfferDto>,
                saves = safeDtoMapper.fromDomainList(saves) as ArrayList<SafeDto>
            )
        }
    }

}