package com.example.orderhw.product

import com.example.orderhw.Presenter
import com.example.orderhw.format

class ProductPresenter(
    private val product: Product
) : Presenter() {
    override fun print() = viewState.print(
        format(
            product.discountPrice
        )
    )
}