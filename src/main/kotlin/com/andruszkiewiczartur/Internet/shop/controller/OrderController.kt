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
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(name = "/api/order")
class OrderController(
    private val orderService: OrderService,
    private val quantityService: QuantityService
) {

    @GetMapping("/{email}")
    fun getOrder(@PathVariable email: String): OrderResponse =
        orderService
            .getOrder(email)
            .toResponse()

    @GetMapping("s/{email}")
    fun getBuyingOrders(@PathVariable email: String): List<OrderResponse> =
        orderService
            .getBuyingOrders(email)
            .map {
                it.toResponse()
            }

    @PostMapping("/buy/{id}")
    fun buyOrder(@PathVariable id: Long) =
        orderService
            .buyOrder(id)

    @PostMapping
    fun addProduct(@RequestBody quantity: QuantityRequest) =
        quantityService.addProduct(
            orderId = quantity.orderId,
            productId = quantity.productId,
            quantity = quantity.quantity
        )

    @DeleteMapping("/{id}")
    fun deleteProduct(@PathVariable id: Long) =
        quantityService
            .deleteProduct(id)
}