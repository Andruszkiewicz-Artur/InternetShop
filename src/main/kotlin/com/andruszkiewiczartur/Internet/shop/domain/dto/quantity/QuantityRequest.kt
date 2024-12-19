package com.andruszkiewiczartur.Internet.shop.domain.dto.quantity

data class QuantityRequest(
    val email: String,
    val productId: Long,
    val quantity: Int
)