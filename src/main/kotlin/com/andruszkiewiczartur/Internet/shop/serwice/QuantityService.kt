package com.andruszkiewiczartur.Internet.shop.serwice

import com.andruszkiewiczartur.Internet.shop.domain.entity.QuantityEntity

interface QuantityService {
    fun addProduct(email: String, productId: Long, quantity: Int): QuantityEntity

    fun deleteProduct(quantityId: Long)
}