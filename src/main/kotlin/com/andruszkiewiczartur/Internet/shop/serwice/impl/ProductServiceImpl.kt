package com.andruszkiewiczartur.Internet.shop.serwice.impl

import com.andruszkiewiczartur.Internet.shop.domain.entity.ProductEntity
import com.andruszkiewiczartur.Internet.shop.repository.ProductRepository
import com.andruszkiewiczartur.Internet.shop.serwice.ProductService
import org.springframework.stereotype.Service

@Service
class ProductServiceImpl(
    private val productRepository: ProductRepository
): ProductService {

    override fun addProduct(product: ProductEntity): ProductEntity =
        productRepository
            .save(product)

    override fun updateProduct(product: ProductEntity): ProductEntity =
        productRepository
            .save(product)

}