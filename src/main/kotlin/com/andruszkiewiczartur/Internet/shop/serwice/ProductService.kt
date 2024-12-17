package com.andruszkiewiczartur.Internet.shop.serwice

import com.andruszkiewiczartur.Internet.shop.domain.entity.ProductEntity

interface ProductService {
    fun addProduct(product: ProductEntity): ProductEntity

    fun updateProduct(product: ProductEntity): ProductEntity
}