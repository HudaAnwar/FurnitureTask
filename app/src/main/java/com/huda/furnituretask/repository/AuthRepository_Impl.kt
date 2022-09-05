package com.huda.furnituretask.repository

import com.huda.furnituretask.domain.model.LoginData
import com.huda.furnituretask.network.AuthService
import com.huda.furnituretask.network.model.*


class AuthRepository_Impl(
    private val authService: AuthService,
    private val mapper: CustomerDtoMapper
) : AuthRepository {

    override suspend fun register(
        name: String,
        email: String,
        phone: String,
        address: String,
        password: String,
        passwordConfirmation: String
    ): LoginData {
        val customerRegistrationInfo =
            CustomerRegistrationInfo(
                name = name,
                email = email,
                phone = phone,
                address = address,
                password = password,
                password_confirmation = passwordConfirmation,
                country_code = "eg"
            )
        val res = authService.register(customerRegistrationInfo)
        val loginData = LoginData(
            res.body()?.status ?: false,
            res.body()?.message ?: res.message(),
            res.body()?.data?.let { customerDto ->
                mapper.mapToDomainModel(customerDto)
            }
        )
        return loginData
    }

    override suspend fun login(username: String, password: String): LoginData {
        val res = authService.login(LoginInformation(username, password))
        val loginData = LoginData(
            res.isSuccessful,
            res.body()?.message ?: res.message(),
            res.body()?.data?.let { customerDto ->
                mapper.mapToDomainModel(customerDto)
            }
        )
        return loginData
    }

    override suspend fun checkSocialLogin(providerType: String, providerId: String): LoginData {
        val res = authService.checkSocialLogin(
            CheckSocialLoginInformation(
                providerType,
                providerId
            )
        )
        val loginData = LoginData(
            res.body()?.status ?: false,
            res.body()?.message ?: res.errorBody().toString(),
            res.body()?.data?.let { customerDto ->
                mapper.mapToDomainModel(customerDto)
            }
        )
        return loginData
    }

    override suspend fun socialLogin(
        providerType: String,
        providerId: String,
        name: String,
        email: String
    ): LoginData {
        val res =
            authService.socialLogin(SocialLoginInformation(providerType, providerId, name, email))
        val loginData = LoginData(
            res.body()?.status ?: false,
            res.body()?.message ?: res.message(),
            res.body()?.data?.let { customerDto ->
                mapper.mapToDomainModel(customerDto)
            }
        )
        return loginData
    }
}