package com.huda.furnituretask.repository

import com.huda.furnituretask.domain.model.*

interface FurnitureRepository {
    suspend fun getHome(): Home?

    suspend fun getCategories(): List<FurnitureCategory>?

    suspend fun getNearByGalleries(lat: Double, lng: Double): List<Gallery>

    suspend fun getOffers(): List<Offer>

    suspend fun getSaves(): List<Safe>

    suspend fun getDiscounts(): List<Discount>

    suspend fun getGalleryDetails(id:Int): GalleryDetails
}