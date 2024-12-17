package com.andruszkiewiczartur.Internet.shop.domain.dto.quantity

import com.andruszkiewiczartur.Internet.shop.domain.dto.product.ProductDto

data class QuantityResponse(
    val id: Long,
    val product: ProductDto,
    val quantity: Int
)
