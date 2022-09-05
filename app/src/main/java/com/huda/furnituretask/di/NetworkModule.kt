package com.huda.furnituretask.di


import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.Scopes
import com.google.android.gms.common.api.Scope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.google.gson.GsonBuilder
import com.huda.furnituretask.R
import com.huda.furnituretask.network.AuthService
import com.huda.furnituretask.network.FurnitureService
import com.huda.furnituretask.network.model.*
import com.huda.furnituretask.presentation.BaseApplication
import com.huda.furnituretask.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideCustomerDtoMapper(): CustomerDtoMapper {
        return CustomerDtoMapper()
    }

    @Singleton
    @Provides
    fun provideHomeDtoMapper(
        branchTypeDtoMapper: BranchTypeDtoMapper,
        categoryDtoMapper: CategoryDtoMapper,
        offerDtoMapper: OfferDtoMapper,
        discountDtoMapper: DiscountDtoMapper,
        safeDtoMapper: SafeDtoMapper
    ): HomeDtoMapper {
        return HomeDtoMapper(
            branchTypeDtoMapper,
            categoryDtoMapper,
            offerDtoMapper,
            safeDtoMapper,
            discountDtoMapper
        )
    }

    @Singleton
    @Provides
    fun provideCategoryDtoMapper(): CategoryDtoMapper {
        return CategoryDtoMapper()
    }

    @Singleton
    @Provides
    fun provideBranchTypeDtoMapper(): BranchTypeDtoMapper {
        return BranchTypeDtoMapper()
    }

    @Singleton
    @Provides
    fun provideColorsDtoMapper(): ColorsDtoMapper {
        return ColorsDtoMapper()
    }

    @Singleton
    @Provides
    fun provideSizesDtoMapper(): SizesDtoMapper {
        return SizesDtoMapper()
    }

    @Singleton
    @Provides
    fun provideProductDtoMapper(): ProductDtoMapper {
        return ProductDtoMapper()
    }

    @Singleton
    @Provides
    fun provideSafeDtoMapper(
        imageDtoMapper: ImageDtoMapper,
        productDtoMapper: ProductDtoMapper
    ): SafeDtoMapper {
        return SafeDtoMapper(imageDtoMapper, productDtoMapper)
    }

    @Singleton
    @Provides
    fun provideOfferDtoMapper(
        imageDtoMapper: ImageDtoMapper,
        productDtoMapper: ProductDtoMapper
    ): OfferDtoMapper {
        return OfferDtoMapper(imageDtoMapper, productDtoMapper)
    }

    @Singleton
    @Provides
    fun provideDiscountDtoMapper(
        imageDtoMapper: ImageDtoMapper
    ): DiscountDtoMapper {
        return DiscountDtoMapper(imageDtoMapper)
    }

    @Singleton
    @Provides
    fun provideTimesOfWeekDtoMapper(): TimesOfWeekDtoMapper {
        return TimesOfWeekDtoMapper()
    }

    @Singleton
    @Provides
    fun provideBranchTypeDetailsDtoMapper(
        timesOfWeekDtoMapper: TimesOfWeekDtoMapper
    ): BranchTypeDetailsDtoMapper {
        return BranchTypeDetailsDtoMapper(timesOfWeekDtoMapper)
    }

    @Singleton
    @Provides
    fun provideFurnitureDtoMapper(
        countryDtoMapper: CountryDtoMapper,
        governorateDtoMapper: GovernorateDtoMapper,
        regionDtoMapper: RegionDtoMapper,
        branchTypeDetailsDtoMapper: BranchTypeDetailsDtoMapper,
        timesOfWeekDtoMapper: TimesOfWeekDtoMapper
    ): FurnitureDtoMapper {
        return FurnitureDtoMapper(
            countryDtoMapper,
            governorateDtoMapper,
            regionDtoMapper,
            branchTypeDetailsDtoMapper,
            timesOfWeekDtoMapper
        )
    }

    @Singleton
    @Provides
    fun provideGalleryDtoMapper(
        countryDtoMapper: CountryDtoMapper,
        regionDtoMapper: RegionDtoMapper,
        governorateDtoMapper: GovernorateDtoMapper
    ): GalleryDtoMapper {
        return GalleryDtoMapper(countryDtoMapper, regionDtoMapper, governorateDtoMapper)
    }

    @Singleton
    @Provides
    fun provideGalleryDetailsDtoMapper(
        furnitureDtoMapper: FurnitureDtoMapper,
        safeDtoMapper: SafeDtoMapper,
        offerDtoMapper: OfferDtoMapper,
        discountDtoMapper: DiscountDtoMapper,
        branchTypeDetailsDtoMapper: BranchTypeDetailsDtoMapper,
        menuDtoMapper: MenuDtoMapper,
        productDetailsDtoMapper: ProductDetailsDtoMapper

    ): GalleryDetailsDtoMapper {
        return GalleryDetailsDtoMapper(
            furnitureDtoMapper,
            safeDtoMapper,
            offerDtoMapper,
            discountDtoMapper,
            branchTypeDetailsDtoMapper,
            menuDtoMapper,
            productDetailsDtoMapper
        )
    }

    @Singleton
    @Provides
    fun provideMenuDtoMapper(
        productDetailsDtoMapper: ProductDetailsDtoMapper,
        categoryDtoMapper: CategoryDtoMapper
    ): MenuDtoMapper {
        return MenuDtoMapper(productDetailsDtoMapper, categoryDtoMapper)
    }

    @Singleton
    @Provides
    fun provideProductDetailsDtoMapper(
        imageDtoMapper: ImageDtoMapper,
        colorsDtoMapper: ColorsDtoMapper,
        sizesDtoMapper: SizesDtoMapper
    ): ProductDetailsDtoMapper {
        return ProductDetailsDtoMapper(imageDtoMapper, colorsDtoMapper, sizesDtoMapper)
    }

    @Singleton
    @Provides
    fun provideCountryDtoMapper(): CountryDtoMapper {
        return CountryDtoMapper()
    }

    @Singleton
    @Provides
    fun provideRegionDtoMapper(): RegionDtoMapper {
        return RegionDtoMapper()
    }

    @Singleton
    @Provides
    fun provideGovernorateDtoMapper(): GovernorateDtoMapper {
        return GovernorateDtoMapper()
    }

    @Singleton
    @Provides
    fun provideImageDtoMapper(): ImageDtoMapper {
        return ImageDtoMapper()
    }

    @Singleton
    @Provides
    fun provideAuthService(): AuthService {
        return getRetrofit()
            .create(AuthService::class.java)
    }

    @Singleton
    @Provides
    fun provideFurnitureService(): FurnitureService {
        return getRetrofit()
            .create(FurnitureService::class.java)
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
    }

    @Singleton
    @Provides
    fun getGoogleSignInOptions(application: BaseApplication): GoogleSignInOptions {
        return GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestScopes(Scope(Scopes.DRIVE_APPFOLDER))
            .requestServerAuthCode(application.resources.getString(R.string.server_client_id))
            .requestEmail()
            .build()
    }

    @Singleton
    @Provides
    fun provideFirebaseAuth(): FirebaseAuth {
        return Firebase.auth

    }
}