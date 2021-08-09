package com.example.shopping_assistant_client.model

data class UnacceptableProductRequest (
    val unacceptable_products: ArrayList<String>
    )

data class UnacceptableProductResponse (
    val unacceptable_products: List<String>
    )

