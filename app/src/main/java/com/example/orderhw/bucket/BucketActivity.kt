package com.example.orderhw.bucket

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.orderhw.MainActivity
import com.example.orderhw.R
import com.example.orderhw.order.OrderActivity
import kotlinx.android.synthetic.main.activity_bucket.*

class BucketActivity : MainActivity(), BucketView {
    private val presenter = BucketPresenter()
    private val adapter = BucketAdapter { p -> presenter.removeItem(p) }

    override fun removeItem(position: Int) = adapter.notifyItemRemoved(position)
    override fun setItems(list: List<String>) = adapter.setItems(list)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bucket)
        basketRv.layoutManager = LinearLayoutManager(this)
        basketRv.adapter = adapter
        presenter.attachView(this)
        presenter.setItems()
        setListeners()
    }

    override fun print(msg: String) {
        TODO("Not yet implemented")
    }

    private fun setListeners() {
        buttonBasketGoBack.setOnClickListener { finish() }
        buttonMakeOrder.setOnClickListener {
            val intent = Intent(this, OrderActivity::class.java)
            startActivity(intent)
        }
    }
}