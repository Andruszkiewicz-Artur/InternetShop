package com.andruszkiewiczartur.Internet.shop.domain.dto.order

import com.andruszkiewiczartur.Internet.shop.domain.dto.quantity.QuantityResponse

data class OrderResponse(
    val id: Long,
    val products: List<QuantityResponse>
)
