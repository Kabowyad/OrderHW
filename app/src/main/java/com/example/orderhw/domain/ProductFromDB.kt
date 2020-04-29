package com.example.orderhw.domain

data class ProductFromDB (
    val name: String,
    val price: Double,
    val discount: Int,
    val description: String,
    val imageUrl: String,
    val id: String
)