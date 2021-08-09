package com.example.shopping_assistant_client.model

data class Product(
    val composition: List<String>,
    val esl: Esl,
    val name: String,
    val unacceptable_products: List<String>
)
