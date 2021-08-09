package com.example.shopping_assistant_client.api

import com.example.shopping_assistant_client.model.*
import com.example.shopping_assistant_client.model.Product
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.Header
import retrofit2.http.POST

interface Login {
    @POST("login")
    suspend fun getToken(
            @Body login: LoginRequest
    ): Response<LoginResponse>
}

interface Registration {
    @POST("registration")
    suspend fun getToken(
        @Body login: LoginRequest
    ): Response<LoginResponse>
}

interface UnacceptableProductPost {
    @POST("unacceptable_products")
    suspend fun setUnacceptableProduct(
        @Header("Authorization") token: String,
        @Body unacceptableProduct: UnacceptableProductRequest
    ): Response<UnacceptableProductResponse>
}

interface UnacceptableProductDelete {
    @DELETE("unacceptable_products")
    suspend fun delUnacceptableProduct(
        @Header("Authorization") token: String,
        @Body unacceptableProduct: UnacceptableProductRequest
    ): Response<UnacceptableProductResponse>
}

interface Product {
    @POST("product")
    suspend fun getProduct(
            @Header("Authorization") token: String,
            @Body barcode: Barcode
    ): Response<Product>
}

interface Refresh {
    @POST("refresh")
    suspend fun getRefreshToken(
            @Header("Authorization") refreshToken: String
    ): Response<LoginResponse>
}