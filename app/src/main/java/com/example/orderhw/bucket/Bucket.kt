package com.example.orderhw.bucket

import com.example.orderhw.product.Product

class Bucket(
    val products: List<Product> = emptyList()
) {
    val discountPrice: Double = products.map { product -> product.discountPrice }.sum()
    val price: Double = products.map { product -> product.price }.sum()
}