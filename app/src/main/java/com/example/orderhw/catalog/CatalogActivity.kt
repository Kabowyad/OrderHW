package com.example.orderhw.catalog

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.orderhw.MainActivity
import com.example.orderhw.R
import com.example.orderhw.bucket.BucketActivity
import kotlinx.android.synthetic.main.activity_catalog.*

class CatalogActivity : MainActivity() {
    private val list = listOf("Item 1", "Item 2", "Item 3")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catalog)
        setListeners()

        catalogRv.layoutManager = LinearLayoutManager(this)
        catalogRv.adapter = CatalogAdapter(list)
    }

    override fun print(msg: String) {
        TODO("Not yet implemented")
    }

    private fun setListeners() {
        buttonToBasket.setOnClickListener {
            val intent = Intent(this, BucketActivity::class.java)
            startActivity(intent)
        }
    }
}