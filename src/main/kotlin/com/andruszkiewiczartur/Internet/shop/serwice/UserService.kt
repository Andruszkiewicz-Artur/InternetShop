package com.andruszkiewiczartur.Internet.shop.serwice

import com.andruszkiewiczartur.Internet.shop.domain.entity.UserEntity

interface UserService {
    fun createUser(user: UserEntity): UserEntity?

    fun getUsers(): List<UserEntity>

    fun logInUser(email: String, password: String): UserEntity?
}