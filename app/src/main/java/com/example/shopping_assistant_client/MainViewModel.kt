package com.example.shopping_assistant_client

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shopping_assistant_client.model.*
import com.example.shopping_assistant_client.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository): ViewModel() {

    var product: MutableLiveData<Response<Product>> = MutableLiveData()
    var accessToken: MutableLiveData<String> = MutableLiveData()
    var refreshToken: MutableLiveData<String> = MutableLiveData()
    var unacceptable: MutableLiveData<Response<UnacceptableProductResponse>> = MutableLiveData()


    fun getToken(login: LoginRequest){
        viewModelScope.launch {
            val responseTokens : Response<LoginResponse> = repository.getToken(login)
            if (responseTokens.isSuccessful) {
                val access_token: String = responseTokens.body()?.access_token.toString()
                accessToken.value = access_token
                val refresh_token: String = responseTokens.body()?.refresh_token.toString()
                refreshToken.value = refresh_token
            }
        }
    }

    fun getTokenReg(login: LoginRequest){
        viewModelScope.launch {
            val responseTokens : Response<LoginResponse> = repository.getTokenReg(login)
            if (responseTokens.isSuccessful) {
                val access_token: String = responseTokens.body()?.access_token.toString()
                accessToken.value = access_token
                val refresh_token: String = responseTokens.body()?.refresh_token.toString()
                refreshToken.value = refresh_token
            }
        }
    }

    fun setUnacceptableProduct(token: String, unacceptableProduct: UnacceptableProductRequest){
        viewModelScope.launch {
            val responseUnacceptableProduct : Response<UnacceptableProductResponse> = repository.setUnacceptableProduct(token, unacceptableProduct)
            if (responseUnacceptableProduct.isSuccessful) {
                unacceptable.value = responseUnacceptableProduct
            }

        }
    }

    fun delUnacceptableProduct(token: String, unacceptableProduct: UnacceptableProductRequest){
        viewModelScope.launch {
            val responseUnacceptableProduct : Response<UnacceptableProductResponse> = repository.delUnacceptableProduct(token, unacceptableProduct)
            if (responseUnacceptableProduct.isSuccessful) {
                unacceptable.value = responseUnacceptableProduct
            }

        }
    }

    fun getProduct(token: String, barcode: Barcode){
        viewModelScope.launch {
            val responseProduct : Response<Product> = repository.getProduct(token, barcode)
            if (responseProduct.isSuccessful) {
                product.value = responseProduct
            }

        }
    }

    fun getRefreshToken(refToken: String){
        viewModelScope.launch {
            val  refreshTokens: Response<LoginResponse> = repository.getRefreshToken(refToken)
            if (refreshTokens.isSuccessful) {
                val access_token: String = refreshTokens.body()?.access_token.toString()
                accessToken.value = access_token
                val refresh_token: String = refreshTokens.body()?.refresh_token.toString()
                refreshToken.value = refresh_token
            }

        }
    }
}


