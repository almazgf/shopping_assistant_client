package com.example.shopping_assistant_client.repository

import com.example.shopping_assistant_client.api.RetrofitBuilder
import com.example.shopping_assistant_client.model.*
import retrofit2.Response

class Repository {

    suspend fun getToken(login: LoginRequest): Response<LoginResponse>{
        return RetrofitBuilder.login.getToken(login)
    }

    suspend fun getTokenReg(login: LoginRequest): Response<LoginResponse>{
        return RetrofitBuilder.registration.getToken(login)
    }

    suspend fun setUnacceptableProduct(token: String, unacceptableProduct: UnacceptableProductRequest ): Response<UnacceptableProductResponse>{
        return RetrofitBuilder.unacceptableProductPost.setUnacceptableProduct(token, unacceptableProduct)
    }

    suspend fun delUnacceptableProduct(token: String, unacceptableProduct: UnacceptableProductRequest ): Response<UnacceptableProductResponse>{
        return RetrofitBuilder.unacceptableProductDelete.delUnacceptableProduct(token, unacceptableProduct)
    }

    suspend fun getProduct(token: String, barcode: Barcode): Response<Product>{
        return RetrofitBuilder.product.getProduct(token, barcode)
    }

    suspend fun getRefreshToken(refreshToken: String): Response<LoginResponse>{
        return RetrofitBuilder.refresh.getRefreshToken(refreshToken)
    }
}