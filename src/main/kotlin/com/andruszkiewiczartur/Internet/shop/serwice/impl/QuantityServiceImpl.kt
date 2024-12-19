package com.andruszkiewiczartur.Internet.shop.serwice.impl

import com.andruszkiewiczartur.Internet.shop.domain.entity.OrderEntity
import com.andruszkiewiczartur.Internet.shop.domain.entity.QuantityEntity
import com.andruszkiewiczartur.Internet.shop.repository.OrderRepository
import com.andruszkiewiczartur.Internet.shop.repository.ProductRepository
import com.andruszkiewiczartur.Internet.shop.repository.QuantityRepository
import com.andruszkiewiczartur.Internet.shop.repository.UserRepository
import com.andruszkiewiczartur.Internet.shop.serwice.QuantityService
import org.springframework.stereotype.Service

@Service
class QuantityServiceImpl(
    private val quantityRepository: QuantityRepository,
    private val orderRepository: OrderRepository,
    private val productRepository: ProductRepository,
    private val userRepository: UserRepository
): QuantityService {

    override fun addProduct(email: String, productId: Long, quantity: Int): QuantityEntity {
        val user = userRepository
            .getReferenceById(email)

        var order = user
            .orders
            .find { !it.isBuying }

        if (order == null) {
            order = orderRepository.save(
                OrderEntity(
                    products = mutableListOf(),
                    isBuying = false
                )
            )

            userRepository.save(
                user.copy(
                    orders = user.orders.toMutableList().also { it.add(order) }
                )
            )
        }

        val orderProduct = order.products.find { it.product.id == productId }

        val quantityResponse = if (orderProduct == null) {
            val product = productRepository.findById(productId).get()

            quantityRepository.save(
                QuantityEntity(
                    product = product,
                    quantity = quantity
                )
            )
        } else {
            quantityRepository.save(
                orderProduct.copy(
                    quantity = quantity
                )
            )
        }

        val newOrder = if (quantityResponse != orderProduct?.product) {
            orderRepository.save(
                order.copy(
                    products = order.products.toMutableList().also {
                        it.addLast(quantityResponse)
                    }
                )
            )
        } else {
            order
        }

        return newOrder.products.last()
    }

    override fun deleteProduct(quantityId: Long) {
        val order = orderRepository
            .findAll()
            .firstOrNull { it.products.firstOrNull { it.id == quantityId } != null }
            ?: throw RuntimeException()

        if(!order.isBuying) {
            val product = order.products.first { it.id == quantityId }

            orderRepository.save(
                order.copy(
                    products = order.products.toMutableList().also {
                        it.remove(product)
                    }
                )
            )
            quantityRepository.deleteById(quantityId)
        }
    }
}