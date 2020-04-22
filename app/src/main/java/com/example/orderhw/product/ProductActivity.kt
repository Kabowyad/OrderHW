package com.example.orderhw.product

import android.os.Bundle
import com.example.orderhw.MainActivity
import com.example.orderhw.R
import kotlinx.android.synthetic.main.activity_product.*

class ProductInfoActivity : MainActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)
        setListeners()
    }

    override fun print(msg: String) {
        TODO("Not yet implemented")
    }

    private fun setListeners() {
        buttonProductGoBack.setOnClickListener { finish() }
    }
}