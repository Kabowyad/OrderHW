package com.example.orderhw.order

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import com.example.orderhw.MainActivity
import com.example.orderhw.Product
import com.example.orderhw.R
import com.example.orderhw.bucket.Bucket
import kotlinx.android.synthetic.main.activity_main.nameFatherField
import kotlinx.android.synthetic.main.activity_main.nameFirstField
import kotlinx.android.synthetic.main.activity_main.nameLastField
import kotlinx.android.synthetic.main.activity_main.phoneField
import kotlinx.android.synthetic.main.activity_main.textViewOrderInfo
import kotlinx.android.synthetic.main.activity_order.*

class OrderActivity : MainActivity(),
    OrderView {
    private val presenter = OrderPresenter(
        bucket = Bucket(
            listOf(
                Product("IPhone", 123.5, 30),
                Product("Samsung", 85.5, 20),
                Product("Xiomi", 50.5, 10)
            )
        ),
        order = Order()
    )

    override fun print(msg: String) {
        textViewOrderInfo.text = msg
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)
        presenter.attachView(this)
        setListeners()
        presenter.print()
    }

    override fun showErrorFirstName(visible: Boolean) = nameFirstField.showError(visible)
    override fun showErrorLastName(visible: Boolean) = nameLastField.showError(visible)
    override fun showErrorFatherName(visible: Boolean) = nameFatherField.showError(visible)
    override fun showErrorPhoneNumber(visible: Boolean) = phoneField.showError(visible)

    private fun setListeners() {
        nameFirstField.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun afterTextChanged(s: Editable?) {
                presenter.setOrderFirstName(s.toString())
            }
        })
        nameLastField.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun afterTextChanged(s: Editable?) {
                presenter.setOrderLastName(s.toString())
            }
        })
        nameFatherField.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun afterTextChanged(s: Editable?) {
                presenter.setOrderFatherName(s.toString())
            }
        })
        phoneField.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun afterTextChanged(s: Editable?) {
                presenter.setOrderPhoneNumber(s.toString())
            }
        })
        buttonOrderGoBack.setOnClickListener { finish() }
    }
}

fun EditText.showError(visible: Boolean) {
    val drawable = if (visible) R.drawable.ic_error_red_24dp else 0
    this.setCompoundDrawablesWithIntrinsicBounds(0, 0, drawable, 0)
}