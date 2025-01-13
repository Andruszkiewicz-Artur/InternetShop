package com.andruszkiewiczartur.Internet.shop.serwice.impl

import com.andruszkiewiczartur.Internet.shop.domain.entity.ProductEntity
import com.andruszkiewiczartur.Internet.shop.repository.ProductRepository
import com.andruszkiewiczartur.Internet.shop.repository.QuantityRepository
import com.andruszkiewiczartur.Internet.shop.serwice.ProductService
import org.springframework.stereotype.Service

@Service
class ProductServiceImpl(
    private val productRepository: ProductRepository,
    private val quantityRepository: QuantityRepository
): ProductService {

    override fun upsertProduct(product: ProductEntity): ProductEntity =
        productRepository
            .save(product)

    override fun getProducts(): List<ProductEntity> =
        productRepository
            .findAll()

    override fun deleteProduct(productId: Long): ProductEntity? {
        val findProductInOrder = quantityRepository
            .findAll()
            .firstOrNull { it.product.id == productId }

        return if (findProductInOrder == null) {
            val product = productRepository.getReferenceById(productId)
            productRepository.deleteById(productId)
            product
        }
        else null
    }

}