package com.example.shopping_assistant_client.model

data class LoginRequest(
    val name: String,
    val password: String
)

data class LoginResponse(
        val access_token: String,
        val refresh_token: String
)

