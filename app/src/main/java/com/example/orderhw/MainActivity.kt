package com.example.orderhw

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View {
    private val presenter: Presenter = BucketPresenter(
        view = this,
        bucket = Bucket(
            listOf(
                Product(name = "Xiaomi", price = 111.5, salePercent = 30),
                Product(name = "Xiaomi 2", price = 100.5, salePercent = 20),
                Product(name = "Xiaomi 3", price = 42.5, salePercent = 10)
            )
        )
    )

    override fun print(msg: String) {
        textViewOrderInfo.text = msg
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.print()
    }
}
