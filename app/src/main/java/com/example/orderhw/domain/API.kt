package com.example.orderhw.domain

import retrofit2.http.GET
import retrofit2.http.Path

interface API {
    @GET("products/all/{author}")
    suspend fun allProducts(@Path("author") author: String = "default"): List<ProductFromDB>
}