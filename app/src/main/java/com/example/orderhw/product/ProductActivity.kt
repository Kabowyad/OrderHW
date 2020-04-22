package com.example.orderhw.product

import android.os.Bundle
import com.example.orderhw.MainActivity
import com.example.orderhw.R
import kotlinx.android.synthetic.main.activity_product.*

class ProductActivity : MainActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)
        setListeners()
    }

    private fun setListeners() {
        buttonProductGoBack.setOnClickListener { finish() }
    }
}