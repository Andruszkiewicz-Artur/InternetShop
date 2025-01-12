package com.andruszkiewiczartur.Internet.shop.domain.entity

import com.andruszkiewiczartur.Internet.shop.domain.dto.user.UserResponse
import com.andruszkiewiczartur.Internet.shop.domain.utils.UserStatus
import jakarta.persistence.*

@Entity
@Table(name = "users")
data class UserEntity(
    @Id
    @Column(nullable = false, unique = true)
    val email: String,
    val password: String,

    @Enumerated(EnumType.STRING)
    val status: UserStatus,

    @OneToMany
    val orders: List<OrderEntity>
) {
    fun toResponse(): UserResponse =
        UserResponse(
            email = email,
            order = orders
                .firstOrNull { !it.isBuying }
                ?.toResponse(),
            status = status.name
        )
}
