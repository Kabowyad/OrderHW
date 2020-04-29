package com.example.orderhw.presentation

import com.example.orderhw.domain.Product
import moxy.MvpPresenter
import kotlin.math.round

class ProductPresenter(
    var product: Product
) : MvpPresenter<ProductView>()

fun format(price: Double): String {
    val roundedPrice = round(100.0 * price) / 100.0
    val digits: Int = if (roundedPrice % 1 > 0) 2 else 0
    return "%.${digits}f".format(roundedPrice)
}