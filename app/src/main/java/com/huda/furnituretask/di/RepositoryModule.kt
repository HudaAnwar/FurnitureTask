package com.huda.furnituretask.di

import com.huda.furnituretask.network.AuthService
import com.huda.furnituretask.network.FurnitureService
import com.huda.furnituretask.network.model.*
import com.huda.furnituretask.repository.AuthRepository
import com.huda.furnituretask.repository.AuthRepository_Impl
import com.huda.furnituretask.repository.FurnitureRepository
import com.huda.furnituretask.repository.FurnitureRepository_Impl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun provideAuthRepository(
        authService: AuthService,
        customerDtoMapper: CustomerDtoMapper
    ): AuthRepository {
        return AuthRepository_Impl(
            authService,
            customerDtoMapper
        )
    }

    @Singleton
    @Provides
    fun provideFurnitureRepository(
        furnitureService: FurnitureService,
        homeDtoMapper: HomeDtoMapper,
        categoryDtoMapper: CategoryDtoMapper,
        galleryDtoMapper: GalleryDtoMapper,
        offerDtoMapper: OfferDtoMapper,
        safeDtoMapper: SafeDtoMapper,
        discountDtoMapper: DiscountDtoMapper,
        galleryDetailsDtoMapper: GalleryDetailsDtoMapper
    ): FurnitureRepository {
        return FurnitureRepository_Impl(
            furnitureService,
            homeDtoMapper,
            categoryDtoMapper,
            galleryDtoMapper,
            offerDtoMapper,
            safeDtoMapper,
            discountDtoMapper,
            galleryDetailsDtoMapper
        )
    }
}