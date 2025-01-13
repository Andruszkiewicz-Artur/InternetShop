package com.andruszkiewiczartur.Internet.shop.domain.dto.product

import com.andruszkiewiczartur.Internet.shop.domain.entity.ProductEntity

data class ProductDto(
    val id: Long,
    val name: String,
    val prize: Float
) {
    fun toEntity(): ProductEntity =
        ProductEntity(
            id = id,
            name = name,
            prize = prize
        )
}
