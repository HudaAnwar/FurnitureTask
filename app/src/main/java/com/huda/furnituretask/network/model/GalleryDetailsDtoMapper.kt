package com.huda.furnituretask.network.model

import com.huda.furnituretask.domain.model.*
import com.huda.furnituretask.domain.util.DomainMapper
import javax.inject.Inject

class GalleryDetailsDtoMapper @Inject constructor(
    private val furnitureDtoMapper: FurnitureDtoMapper,
    private val safeDtoMapper: SafeDtoMapper,
    private val offerDtoMapper: OfferDtoMapper,
    private val discountDtoMapper: DiscountDtoMapper,
    private val branchTypeDetailsDtoMapper: BranchTypeDetailsDtoMapper,
    private val menuDtoMapper: MenuDtoMapper,
    private val productDetailsDtoMapper: ProductDetailsDtoMapper
) : DomainMapper<GalleryDetailsDto, GalleryDetails> {
    override fun mapToDomainModel(model: GalleryDetailsDto): GalleryDetails {

        with(model) {
            return GalleryDetails(
                furniture = furniture?.let { furnitureDtoMapper.mapToDomainModel(it) },
                saves = safeDtoMapper.toDomainList(saves) as ArrayList<Safe>,
                offers = offerDtoMapper.toDomainList(offers) as ArrayList<Offer>,
                discounts = discountDtoMapper.toDomainList(discounts) as ArrayList<Discount>,
                branches = branchTypeDetailsDtoMapper.toDomainList(branches) as ArrayList<BranchTypeDetails>,
                extras = extras,
                favourites = favourites,
                menu = menuDtoMapper.toDomainList(menu) as ArrayList<Menu>,
                mostWantedProducts = productDetailsDtoMapper.toDomainList(mostWantedProducts) as ArrayList<ProductDetails>,
                rates = rates
            )
        }
    }

    override fun mapFromDomainModel(domainModel: GalleryDetails): GalleryDetailsDto {
        with(domainModel) {
            return GalleryDetailsDto(
                furniture = furniture?.let { furnitureDtoMapper.mapFromDomainModel(it) },
                saves = safeDtoMapper.fromDomainList(saves) as ArrayList<SafeDto>,
                offers = offerDtoMapper.fromDomainList(offers) as ArrayList<OfferDto>,
                discounts = discountDtoMapper.fromDomainList(discounts) as ArrayList<DiscountDto>,
                branches = branchTypeDetailsDtoMapper.fromDomainList(branches) as ArrayList<BranchTypeDetailsDto>,
                extras = extras,
                favourites = favourites,
                menu = menuDtoMapper.fromDomainList(menu) as ArrayList<MenuDto>,
                mostWantedProducts = productDetailsDtoMapper.fromDomainList(mostWantedProducts) as ArrayList<ProductDetailsDto>,
                rates = rates
            )
        }
    }

}