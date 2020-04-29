package com.example.orderhw.ui

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.orderhw.R
import com.example.orderhw.data.ViewedProductsDaoImp
import com.example.orderhw.domain.Product
import com.example.orderhw.presentation.BucketPresenter
import com.example.orderhw.presentation.BucketView
import kotlinx.android.synthetic.main.activity_bucket.*
import moxy.ktx.moxyPresenter

class BucketActivity : MainActivity(), BucketView {
    private val presenter by moxyPresenter {
        BucketPresenter (
            ViewedProductsDaoImp(sharedPreferences)
        )
    }
    private val adapter = BucketAdapter(
        { p -> presenter.removeItem(p) },
        { p -> openProductInfo(p) }
    )

    override fun removeItem(position: Int) = adapter.notifyItemRemoved(position)
    override fun setItems(products: List<Product>) = adapter.setItems(products)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bucket)
        basketRv.layoutManager = LinearLayoutManager(this)
        basketRv.adapter = adapter
        setListeners()
    }

    override fun showProductIds(productIds: List<Long>) {
        Toast.makeText(this, productIds.joinToString(","), Toast.LENGTH_LONG).show()
    }

    private fun setListeners() {
        buttonBasketGoBack.setOnClickListener { finish() }
        buttonMakeOrder.setOnClickListener {
            startActivity(Intent(this, OrderActivity::class.java))
        }
    }

    private fun openProductInfo(product: Product) = startActivity(
        Intent(this, ProductActivity::class.java)
            .apply { putExtra(ProductActivity.PRODUCT_TAG, product) })
}

val AppCompatActivity.sharedPreferences: SharedPreferences
    get() = getSharedPreferences("data", Context.MODE_PRIVATE)