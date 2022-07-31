package com.huda.furnituretask.di


import com.google.gson.GsonBuilder
import com.huda.furnituretask.network.AuthService
import com.huda.furnituretask.network.model.CustomerDtoMapper
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
    fun provideAuthService(): AuthService {
        return getRetrofit()
            .create(AuthService::class.java)
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
    }

}