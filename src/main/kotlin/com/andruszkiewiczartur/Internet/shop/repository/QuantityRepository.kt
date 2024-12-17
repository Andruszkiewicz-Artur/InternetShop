package com.andruszkiewiczartur.Internet.shop.repository

import com.andruszkiewiczartur.Internet.shop.domain.entity.QuantityEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface QuantityRepository: JpaRepository<QuantityEntity, Long>