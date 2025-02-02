package com.andruszkiewiczartur.Internet.shop.serwice

import com.andruszkiewiczartur.Internet.shop.domain.entity.OrderEntity
import com.andruszkiewiczartur.Internet.shop.domain.entity.ProductEntity

interface OrderService {
    fun getOrders(userEmail: String): List<OrderEntity>

    fun buyOrder(orderId: Long): OrderEntity
}