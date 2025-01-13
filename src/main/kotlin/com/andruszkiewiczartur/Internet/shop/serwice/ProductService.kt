package com.andruszkiewiczartur.Internet.shop.serwice

import com.andruszkiewiczartur.Internet.shop.domain.dto.product.ProductDto
import com.andruszkiewiczartur.Internet.shop.domain.entity.ProductEntity

interface ProductService {
    fun upsertProduct(product: ProductEntity): ProductEntity

    fun getProducts(): List<ProductEntity>

    fun deleteProduct(productId: Long): ProductEntity?
}