package com.andruszkiewiczartur.Internet.shop.serwice.impl

import com.andruszkiewiczartur.Internet.shop.domain.entity.OrderEntity
import com.andruszkiewiczartur.Internet.shop.repository.OrderRepository
import com.andruszkiewiczartur.Internet.shop.repository.UserRepository
import com.andruszkiewiczartur.Internet.shop.serwice.OrderService
import org.springframework.stereotype.Service

@Service
class OrderServiceImpl(
    private val orderRepository: OrderRepository,
    private val userRepository: UserRepository
): OrderService {
    override fun getOrders(userEmail: String): List<OrderEntity> =
        userRepository
            .findAll()
            .firstOrNull { it.email == userEmail }
            ?.orders
            ?.filter { it.isBuying == true }
            ?: emptyList()

    override fun buyOrder(orderId: Long): OrderEntity {
        val order = orderRepository
            .findById(orderId)
            .get()
            .copy(
                isBuying = true
            )

        if (order.products.isEmpty()) throw RuntimeException()

        val newOrder = orderRepository.save(order)

        return newOrder
    }
}