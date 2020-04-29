package com.example.orderhw.presentation

import com.example.orderhw.domain.API
import com.example.orderhw.domain.Product
import kotlinx.coroutines.launch
import moxy.InjectViewState

@InjectViewState
class CatalogPresenter(
    private val api: API
) : CoroutinePresenter<CatalogView>() {
    var products = listOf(
        Product("Call of Duty Warzone", 130.0),
        Product("Animal Crossing", 150.0, 20),
        Product("Doom Eternal", 115.0)
    )


    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        launch {
            val remoteProducts = api.allProducts()
            products = remoteProducts.mapNotNull { r ->
                try {
                    Product(r.name, r.price, r.discount, r.description, r.id)
                } catch (e: VerifyError) {
                    null
                }
            }
            viewState.setItems(products)
        }
    }
}