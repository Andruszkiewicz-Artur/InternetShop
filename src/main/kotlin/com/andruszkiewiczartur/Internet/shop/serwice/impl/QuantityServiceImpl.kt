package com.andruszkiewiczartur.Internet.shop.serwice.impl

import com.andruszkiewiczartur.Internet.shop.domain.entity.QuantityEntity
import com.andruszkiewiczartur.Internet.shop.repository.OrderRepository
import com.andruszkiewiczartur.Internet.shop.repository.ProductRepository
import com.andruszkiewiczartur.Internet.shop.repository.QuantityRepository
import com.andruszkiewiczartur.Internet.shop.serwice.QuantityService
import org.springframework.stereotype.Service

@Service
class QuantityServiceImpl(
    private val quantityRepository: QuantityRepository,
    private val orderRepository: OrderRepository,
    private val productRepository: ProductRepository
): QuantityService {

    override fun addProduct(orderId: Long, productId: Long, quantity: Int): QuantityEntity =
        quantityRepository.save(
            QuantityEntity(
                order = orderRepository.getReferenceById(orderId),
                product = productRepository.getReferenceById(productId),
                quantity = quantity
            )
        )

    override fun updateProduct(quantityId: Long, quantity: Int): QuantityEntity =
        quantityRepository.save(
            quantityRepository.
            getReferenceById(quantityId)
                .copy(
                    quantity = quantity
                )
        )

    override fun deleteProduct(quantityId: Long) =
        quantityRepository.deleteById(quantityId)
}