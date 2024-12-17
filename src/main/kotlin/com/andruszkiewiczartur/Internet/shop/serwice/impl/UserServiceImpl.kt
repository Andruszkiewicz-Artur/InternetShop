package com.andruszkiewiczartur.Internet.shop.serwice.impl

import com.andruszkiewiczartur.Internet.shop.domain.entity.UserEntity
import com.andruszkiewiczartur.Internet.shop.repository.UserRepository
import com.andruszkiewiczartur.Internet.shop.serwice.UserService
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    private val userRepository: UserRepository
): UserService {

    override fun createUser(user: UserEntity): UserEntity = userRepository.save(user)

}