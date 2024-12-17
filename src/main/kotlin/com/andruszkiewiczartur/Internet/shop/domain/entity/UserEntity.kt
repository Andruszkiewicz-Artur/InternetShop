package com.andruszkiewiczartur.Internet.shop.domain.entity

import com.andruszkiewiczartur.Internet.shop.domain.utils.UserStatus
import jakarta.persistence.*

@Entity
@Table(name = "users")
data class UserEntity(
    @Id
    @GeneratedValue
    val email: String,
    val password: String,
    val status: UserStatus,

    @OneToMany
    val orders: List<OrderEntity>
)
