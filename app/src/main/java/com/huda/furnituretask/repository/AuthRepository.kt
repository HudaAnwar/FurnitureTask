package com.huda.furnituretask.repository

import com.huda.furnituretask.domain.model.Customer
import com.huda.furnituretask.domain.model.LoginData

interface AuthRepository {
    suspend fun register(
        name: String,
        email: String,
        phone: String,
        address: String,
        password: String,
        passwordConfirmation: String
    ): LoginData

    suspend fun login(username: String, password: String): LoginData

    suspend fun checkSocialLogin(providerType: String, providerId: String): LoginData

    suspend fun socialLogin(
        providerType: String,
        providerId: String,
        name: String,
        email: String
    ): LoginData
}