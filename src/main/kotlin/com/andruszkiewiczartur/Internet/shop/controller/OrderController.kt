package com.andruszkiewiczartur.Internet.shop.controller

import com.andruszkiewiczartur.Internet.shop.domain.dto.order.OrderResponse
import com.andruszkiewiczartur.Internet.shop.domain.dto.quantity.QuantityRequest
import com.andruszkiewiczartur.Internet.shop.serwice.OrderService
import com.andruszkiewiczartur.Internet.shop.serwice.QuantityService
import com.andruszkiewiczartur.Internet.shop.serwice.impl.OrderServiceImpl
import com.andruszkiewiczartur.Internet.shop.serwice.impl.QuantityServiceImpl
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/order")
class OrderController(
    private val orderService: OrderService,
    private val quantityService: QuantityService
) {
    @GetMapping
    fun getOrders(@RequestParam email: String): List<OrderResponse> =
        orderService
            .getOrders(email)
            .map {
                it.toResponse()
            }

    @PostMapping("/buy")
    fun buyOrder(@RequestParam id: Long) =
        orderService
            .buyOrder(id)

    @PostMapping("/product")
    fun addProduct(@RequestBody quantity: QuantityRequest) =
        quantityService.addProduct(
            email = quantity.email,
            productId = quantity.productId,
            quantity = quantity.quantity
        )

    @DeleteMapping("/product")
    fun deleteProduct(@RequestParam id: Long) =
        quantityService
            .deleteProduct(id)
}