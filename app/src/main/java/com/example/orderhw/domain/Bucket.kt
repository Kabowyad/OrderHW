package com.example.orderhw.domain

class Bucket(
    val products: MutableList<Product> = mutableListOf()
) {
    fun getPrice(): Double = products.map { product -> product.price }.sum()
    fun getDiscountPrice(): Double = products.map { product -> product.discountPrice }.sum()
}