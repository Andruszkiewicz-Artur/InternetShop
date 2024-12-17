package com.andruszkiewiczartur.Internet.shop.domain.entity

import com.andruszkiewiczartur.Internet.shop.domain.dto.quantity.QuantityResponse
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToOne
import jakarta.persistence.Table

@Entity
@Table(name = "Quantities")
data class QuantityEntity(
    @Id
    @GeneratedValue
    val id: Long = 0,

    @ManyToOne
    val order: OrderEntity,

    @OneToOne
    @JoinColumn(name = "product_id")
    val product: ProductEntity,

    val quantity: Int
) {
    fun toResponse(): QuantityResponse =
        QuantityResponse(
            id = id,
            product = product.toDto(),
            quantity = quantity
        )
}
