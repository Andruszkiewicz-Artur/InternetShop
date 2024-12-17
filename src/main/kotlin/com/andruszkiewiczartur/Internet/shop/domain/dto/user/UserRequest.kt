package com.andruszkiewiczartur.Internet.shop.domain.dto.user

import com.andruszkiewiczartur.Internet.shop.domain.entity.UserEntity
import com.andruszkiewiczartur.Internet.shop.domain.utils.UserStatus

data class UserRequest(
    val email: String,
    val password: String,
    val status: String
) {
    fun toEntity(): UserEntity =
        UserEntity(
            email = email,
            password = password,
            status = UserStatus.valueOf(status),
            orders = emptyList()
        )
}
