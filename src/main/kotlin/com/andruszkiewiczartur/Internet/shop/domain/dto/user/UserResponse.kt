package com.andruszkiewiczartur.Internet.shop.domain.dto.user

import com.andruszkiewiczartur.Internet.shop.domain.dto.order.OrderResponse

data class UserResponse(
    val email: String,
    val status: String,
    val order: OrderResponse?
)
