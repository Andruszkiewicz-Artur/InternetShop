package com.andruszkiewiczartur.Internet.shop.domain.entity

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
    val orders: List<ProductEntity> = mutableListOf()
)