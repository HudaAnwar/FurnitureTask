package com.huda.furnituretask.network

import com.huda.furnituretask.network.model.CustomerDto
import com.huda.furnituretask.network.model.LoginInformation
import com.huda.furnituretask.network.responses.LoginResponse
import com.huda.furnituretask.network.responses.RegistrationResponse
import retrofit2.Response
import retrofit2.http.*

interface AuthService {
    @Headers("Content-Type:application/json")
    @POST("register")
    suspend fun register(
        @Body customerDto: CustomerDto
    ): Response<RegistrationResponse>

    @POST("login")
    suspend fun login(
        @Body loginInformation: LoginInformation
    ): Response<LoginResponse>
}