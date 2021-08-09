package com.example.shopping_assistant_client.api

import com.example.shopping_assistant_client.util.Constant.Companion.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    private val client = OkHttpClient.Builder().apply {
        addInterceptor(HeadInterceptor())
    }.build()

    private val retrofit by lazy{
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    val login:Login by lazy{
        retrofit.create(Login::class.java)
    }

    val registration:Registration by lazy {
        retrofit.create(Registration::class.java)
    }

    val unacceptableProductPost:UnacceptableProductPost by lazy{
        retrofit.create(UnacceptableProductPost::class.java)
    }

    val unacceptableProductDelete:UnacceptableProductDelete by lazy{
        retrofit.create(UnacceptableProductDelete::class.java)
    }

    val product:Product by lazy{
        retrofit.create(Product::class.java)
    }

    val refresh: Refresh by lazy{
        retrofit.create(Refresh::class.java)
    }


}