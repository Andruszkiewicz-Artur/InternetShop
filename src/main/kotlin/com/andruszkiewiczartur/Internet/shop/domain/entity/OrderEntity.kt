package com.andruszkiewiczartur.Internet.shop.domain.entity

import com.andruszkiewiczartur.Internet.shop.domain.dto.order.OrderResponse
import jakarta.persistence.*

@Entity
@Table(name = "Orders")
data class OrderEntity(
    @Id
    @GeneratedValue
    val id: Long = 0,

    @ManyToOne
    @JoinColumn(name = "user_email")
    val user: UserEntity,

    @OneToMany
    @JoinColumn(name = "quantity_id")
    val products: List<QuantityEntity>,

    val isBuying: Boolean
) {
    fun toResponse(): OrderResponse =
        OrderResponse(
            id = id,
            products = products
                .map { it.toResponse() }
        )
}
