package com.example.orderhw.ui

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.orderhw.R
import com.example.orderhw.domain.API
import com.example.orderhw.domain.Product
import com.example.orderhw.presentation.CatalogPresenter
import com.example.orderhw.presentation.CatalogView
import com.example.orderhw.ui.ProductActivity.Companion.PRODUCT_TAG
import kotlinx.android.synthetic.main.activity_catalog.*
import moxy.ktx.moxyPresenter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CatalogActivity : MainActivity(), CatalogView {
    private val retrofit = Retrofit.Builder()
        .baseUrl("http://207.254.71.167:9191/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val api = retrofit.create(API::class.java)
    private val presenter by moxyPresenter { CatalogPresenter(api) }
    private val adapter = CatalogAdapter { openProductInfo(it) }

    override fun setItems(products: List<Product>) = adapter.setItems(products)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catalog)
        setListeners()
        catalogRv.layoutManager = LinearLayoutManager(this)
        catalogRv.adapter = adapter
    }

    private fun setListeners() {
        buttonToBasket.setOnClickListener {
            val intent = Intent(this, BucketActivity::class.java)
            startActivity(intent)
        }
    }

    private fun openProductInfo(product: Product) = startActivity(
        Intent(this, ProductActivity::class.java)
            .apply { putExtra(PRODUCT_TAG, product) })
}
