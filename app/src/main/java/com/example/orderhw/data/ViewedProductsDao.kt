package com.example.orderhw.data

interface ViewedProductsDao {
    fun addProduct(productId: Long)
    fun getAllProducts(): List<Long>
}