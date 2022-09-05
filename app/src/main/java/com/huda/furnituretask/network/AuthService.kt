package com.huda.furnituretask.network

import com.huda.furnituretask.network.model.CheckSocialLoginInformation
import com.huda.furnituretask.network.model.CustomerRegistrationInfo
import com.huda.furnituretask.network.model.LoginInformation
import com.huda.furnituretask.network.model.SocialLoginInformation
import com.huda.furnituretask.network.responses.LoginResponse
import retrofit2.Response
import retrofit2.http.*

interface AuthService {
    @Headers("Content-Type:application/json")
    @POST("register")
    suspend fun register(
        @Body customerRegistrationInfo: CustomerRegistrationInfo
    ): Response<LoginResponse>

    @POST("login")
    suspend fun login(
        @Body loginInformation: LoginInformation
    ): Response<LoginResponse>

    @POST("check/social")
    suspend fun checkSocialLogin(
        @Body checkSocialLoginInformation: CheckSocialLoginInformation
    ): Response<LoginResponse>

    @POST("login/social")
    suspend fun socialLogin(
        @Body socialLoginInformation: SocialLoginInformation
    ): Response<LoginResponse>
}