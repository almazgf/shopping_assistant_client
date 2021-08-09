package com.example.shopping_assistant_client.api

import okhttp3.Interceptor
import okhttp3.Response


class HeadInterceptor: Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        val request = chain.request()
            .newBuilder()
            .build()
        return chain.proceed(request)
    }

}