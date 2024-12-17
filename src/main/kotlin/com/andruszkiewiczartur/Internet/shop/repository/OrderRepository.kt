package com.andruszkiewiczartur.Internet.shop.repository

import com.andruszkiewiczartur.Internet.shop.domain.entity.OrderEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OrderRepository: JpaRepository<OrderEntity, Long>