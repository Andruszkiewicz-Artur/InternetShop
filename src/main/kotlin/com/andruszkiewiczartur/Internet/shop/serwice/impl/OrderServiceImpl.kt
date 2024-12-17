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

    override fun getOrder(orderId: Long): OrderEntity =
        orderRepository
            .getReferenceById(orderId)

    override fun getBuyingOrders(userEmail: String): List<OrderEntity> =
        userRepository
            .getReferenceById(userEmail)
            .orders
            .filter { it.isBuying == true }

    override fun buyOrder(orderId: Long): OrderEntity =
        orderRepository
            .save(
                orderRepository
                    .getReferenceById(orderId)
                    .copy(isBuying = true)
            )
}