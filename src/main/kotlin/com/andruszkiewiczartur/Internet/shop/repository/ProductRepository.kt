package com.andruszkiewiczartur.Internet.shop.repository

import com.andruszkiewiczartur.Internet.shop.domain.entity.ProductEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository: JpaRepository<ProductEntity, Long>