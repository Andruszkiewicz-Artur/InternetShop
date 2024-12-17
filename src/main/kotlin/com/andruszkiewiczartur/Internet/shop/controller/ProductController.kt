package com.andruszkiewiczartur.Internet.shop.controller

import com.andruszkiewiczartur.Internet.shop.domain.dto.product.ProductDto
import com.andruszkiewiczartur.Internet.shop.serwice.ProductService
import com.andruszkiewiczartur.Internet.shop.serwice.impl.ProductServiceImpl
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/product")
class ProductController(
    private val productService: ProductService
) {

    @PostMapping
    fun createProduct(@RequestBody product: ProductDto) =
        productService
            .upsertProduct(
                product.toEntity()
            )


    @GetMapping
    fun getAllProducts(): List<ProductDto> =
        productService
            .getProducts()
            .map { it.toDto() }

}