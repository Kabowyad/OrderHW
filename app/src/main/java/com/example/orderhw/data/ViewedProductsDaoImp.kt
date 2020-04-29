package com.example.orderhw.data

import android.content.SharedPreferences
import androidx.core.content.edit

class ViewedProductsDaoImp(private val sharedPreferences: SharedPreferences) : ViewedProductsDao {

    private val PRODUCT_TAG = "PRODUCT_TAG"

    private var savedProductIds: List<Long>
        get() = sharedPreferences.getString(PRODUCT_TAG, null)
            ?.split(",")
            ?.mapNotNull { it.toLongOrNull() } ?: emptyList()
        set(value) {
            sharedPreferences.edit {
                putString(PRODUCT_TAG, value.joinToString(","))
            }
        }

    override fun getAllProducts(): List<Long> = savedProductIds
    override fun addProduct(productId: Long) {
        val productIds: List<Long> = savedProductIds
        val newProductIds = mutableListOf<Long>().apply {
            add(productId)
            addAll(productIds.filter { it != productId })
        }
        savedProductIds = newProductIds
    }
}