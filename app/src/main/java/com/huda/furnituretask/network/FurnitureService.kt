package com.huda.furnituretask.network

import com.example.example.FurnitureResponse
import com.example.example.OfferResponse
import com.huda.furnituretask.network.model.*
import com.huda.furnituretask.network.responses.CategoriesResponse
import com.huda.furnituretask.network.responses.GalleryDetailsResponse
import com.huda.furnituretask.network.responses.GalleryResponse
import com.huda.furnituretask.network.responses.HomeResponse
import retrofit2.Response
import retrofit2.http.*

interface FurnitureService {
    @GET("home?country_id=1")
    suspend fun getHome(): Response<HomeResponse>

    @GET("home/categories?country_id=1")
    suspend fun getCategories(): Response<CategoriesResponse>

    @POST("home/furniture-nearby?country_id=1")
    suspend fun getFurnitureNearBy(@Body coordinates: Coordinates): Response<FurnitureResponse<GalleryDto>>

    @GET("furniture/{id}?country_id=1")
    suspend fun getGalleryDetails(@Path("id") id:Int): Response<GalleryDetailsResponse>

    @GET("home/offers?price=ASC&country_id=1")
    suspend fun getOffers(): Response<FurnitureResponse<OfferDto>>

    @GET("home/saves?price=DESC&country_id=1")
    suspend fun getSaves(): Response<FurnitureResponse<SafeDto>>

    @GET("home/discounts?price=DESC&country_id=1")
    suspend fun getDiscounts(): Response<FurnitureResponse<DiscountDto>>

}