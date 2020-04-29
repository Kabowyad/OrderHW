package com.example.orderhw.presentation

import com.example.orderhw.data.ViewedProductsDao
import com.example.orderhw.domain.Bucket
import com.example.orderhw.domain.Product
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class BucketPresenter(
    private val viewedProductDao: ViewedProductsDao
) : MvpPresenter<BucketView>() {
    private val basket = Bucket(
        mutableListOf(
            Product("Doom 2016", 100.0),
            Product("Doom Eternal", 120.0, 15)
        )
    )

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        setItems()
    }

    override fun attachView(view: BucketView?) {
        super.attachView(view)
        val productIds = viewedProductDao.getAllProducts()
        viewState.showProductIds(productIds)
    }

    fun setItems() = viewState.setItems(basket.products)

    fun removeItem(name: String) {
        val product = basket.products.find { p -> p.name == name }
        val position = basket.products.indexOf(product)
        basket.products.removeAt(position)
        viewState.removeItem(position)
    }
}