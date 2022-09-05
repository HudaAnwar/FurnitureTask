package com.huda.furnituretask.repository

import com.huda.furnituretask.domain.model.*
import com.huda.furnituretask.network.FurnitureService
import com.huda.furnituretask.network.model.*


class FurnitureRepository_Impl(
    private val furnitureService: FurnitureService,
    private val homeDtoMapper: HomeDtoMapper,
    private val categoryDtoMapper: CategoryDtoMapper,
    private val galleryDtoMapper: GalleryDtoMapper,
    private val offerDtoMapper: OfferDtoMapper,
    private val safeDtoMapper: SafeDtoMapper,
    private val discountDtoMapper: DiscountDtoMapper,
    private val galleryDetailsDtoMapper: GalleryDetailsDtoMapper
) : FurnitureRepository {

    override suspend fun getHome(): Home? {
        val res = furnitureService.getHome()
        return res.body()?.data?.let { homeDtoMapper.mapToDomainModel(it) }
    }

    override suspend fun getCategories(): List<FurnitureCategory>? {
        val res = furnitureService.getCategories()
        return res.body()?.data?.let { categoryDtoMapper.toDomainList(it as ArrayList<FurnitureCategoryDto>) }

    }

    override suspend fun getNearByGalleries(lat: Double, lng: Double): List<Gallery> {
        val coordinates = Coordinates(lat, lng)
        val res = furnitureService.getFurnitureNearBy(coordinates)
        return res.body()?.data?.let { galleryDtoMapper.toDomainList(it) }?: listOf()
    }

    override suspend fun getOffers(): List<Offer> {
        val res = furnitureService.getOffers()
        return res.body()?.data?.let { offerDtoMapper.toDomainList(it) } ?: listOf()
    }

    override suspend fun getSaves(): List<Safe> {
        val res = furnitureService.getSaves()
        return res.body()?.data?.let { safeDtoMapper.toDomainList(it) } ?: listOf()
    }

    override suspend fun getDiscounts(): List<Discount> {
        val res = furnitureService.getDiscounts()
        return res.body()?.data?.let { discountDtoMapper.toDomainList(it) } ?: listOf()
    }

    override suspend fun getGalleryDetails(id: Int): GalleryDetails {
        val res = furnitureService.getGalleryDetails(id)
        return res.body()?.data?.let { galleryDetailsDtoMapper.mapToDomainModel(it) }?: GalleryDetails()
    }

}