package com.andruszkiewiczartur.Internet.shop.domain.dto.quantity

data class QuantityRequest(
    val id: Long = 0,
    val orderId: Long,
    val productId: Long,
    val quantity: Int
)