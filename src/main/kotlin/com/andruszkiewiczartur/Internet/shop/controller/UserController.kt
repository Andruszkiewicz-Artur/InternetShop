package com.andruszkiewiczartur.Internet.shop.controller

import com.andruszkiewiczartur.Internet.shop.domain.dto.user.UserLoginRequest
import com.andruszkiewiczartur.Internet.shop.domain.dto.user.UserRequest
import com.andruszkiewiczartur.Internet.shop.domain.dto.user.UserResponse
import com.andruszkiewiczartur.Internet.shop.serwice.UserService
import com.andruszkiewiczartur.Internet.shop.serwice.impl.UserServiceImpl
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/user")
class UserController(
    private val userService: UserService
) {

    @PostMapping
    fun createUser(@RequestBody user: UserRequest): UserResponse? =
        userService
            .createUser(user.toEntity())
            ?.toResponse()

    @GetMapping
    fun getUsers(): List<UserResponse> =
        userService
            .getUsers()
            .map {
                it.toResponse()
            }

    @GetMapping("/login")
    fun logInUser(@RequestParam email: String, @RequestParam password: String): UserResponse? =
        userService
            .logInUser(email, password)
            ?.toResponse()

    @PutMapping("/changePassword")
    fun changePassword(@RequestParam email: String, @RequestParam oldPassword: String, @RequestParam newPassword: String): UserResponse? =
        userService
            .changePassword(email, oldPassword, newPassword)
            ?.toResponse()

}