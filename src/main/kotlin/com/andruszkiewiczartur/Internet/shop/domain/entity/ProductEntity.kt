package com.andruszkiewiczartur.Internet.shop.domain.entity

import com.andruszkiewiczartur.Internet.shop.domain.dto.product.ProductDto
import jakarta.persistence.*

@Entity
@Table(name = "products")
data class ProductEntity(
    @Id
    @GeneratedValue
    val id: Long = 0,
    val name: String,
    val prize: Float,

    @ManyToMany
    val orders: List<OrderEntity> = mutableListOf()
) {

    fun toDto(): ProductDto =
        ProductDto(
            id = id,
            name = name,
            prize = prize
        )
}