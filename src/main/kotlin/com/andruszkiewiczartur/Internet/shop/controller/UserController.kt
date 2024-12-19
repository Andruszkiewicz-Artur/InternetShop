package com.andruszkiewiczartur.Internet.shop.controller

import com.andruszkiewiczartur.Internet.shop.domain.dto.user.UserRequest
import com.andruszkiewiczartur.Internet.shop.domain.dto.user.UserResponse
import com.andruszkiewiczartur.Internet.shop.serwice.UserService
import com.andruszkiewiczartur.Internet.shop.serwice.impl.UserServiceImpl
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/user")
class UserController(
    private val userService: UserService
) {

    @PostMapping
    fun createUser(@RequestBody user: UserRequest) =
        userService.createUser(user.toEntity())

    @GetMapping
    fun getUsers(): List<UserResponse> =
        userService
            .getUsers()
            .map {
                it.toResponse()
            }
}