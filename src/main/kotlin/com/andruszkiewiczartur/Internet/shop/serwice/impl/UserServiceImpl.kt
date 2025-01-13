package com.andruszkiewiczartur.Internet.shop.serwice.impl

import com.andruszkiewiczartur.Internet.shop.domain.entity.UserEntity
import com.andruszkiewiczartur.Internet.shop.repository.UserRepository
import com.andruszkiewiczartur.Internet.shop.serwice.UserService
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    private val userRepository: UserRepository
): UserService {

    override fun createUser(user: UserEntity): UserEntity? {
        val userInner = userRepository
            .findAll()
            .firstOrNull { user.email == it.email }

        if (userInner != null) return null

        return userRepository
            .save(user)
    }


    override fun getUsers(): List<UserEntity> =
        userRepository
            .findAll()

    override fun logInUser(email: String, password: String): UserEntity? =
        userRepository
            .findAll()
            .firstOrNull { it.email == email && it.password == password }

    override fun changePassword(email: String, oldPassword: String, newPassword: String): UserEntity? {
        val user = userRepository
            .findAll()
            .firstOrNull { it.email == email && it.password == oldPassword }

        return if (user != null) {
            userRepository
                .save(user.copy(
                    password = newPassword
                ))
        }
        else null
    }
}