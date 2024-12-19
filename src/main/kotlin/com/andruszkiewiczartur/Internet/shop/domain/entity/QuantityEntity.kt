package com.andruszkiewiczartur.Internet.shop.domain.entity

import com.andruszkiewiczartur.Internet.shop.domain.dto.quantity.QuantityResponse
import jakarta.persistence.*

@Entity
@Table(name = "Quantities")
data class QuantityEntity(
    @Id
    @GeneratedValue
    val id: Long = 0,

    @ManyToOne
    @JoinColumn(name = "product_id")
    val product: ProductEntity,

    val quantity: Int
) {
    fun toResponse(): QuantityResponse =
        QuantityResponse(
            product = product.toDto(),
            quantity = quantity,
            id = id
        )
}
