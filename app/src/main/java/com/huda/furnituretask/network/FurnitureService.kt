package com.huda.furnituretask.network

import com.huda.furnituretask.network.model.CustomerDto
import com.huda.furnituretask.network.responses.HomeResponse
import com.huda.furnituretask.network.responses.RegistrationResponse
import retrofit2.Response
import retrofit2.http.*

interface FurnitureService {
    @GET("home")
    suspend fun getHome(): Response<HomeResponse>

//    @GET("authors/{id}")
//    suspend fun login(
//         @Path("id") id: Int
//    ): AuthorDto
}