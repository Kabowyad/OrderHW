package com.example.orderhw.presentation

import com.example.orderhw.domain.Bucket
import com.example.orderhw.domain.Order
import com.example.orderhw.domain.Product
import moxy.MvpPresenter

class OrderPresenter : MvpPresenter<OrderView>() {
    private val order = Order()
    private val basket: Bucket = Bucket(
        mutableListOf(
            Product("BMW X3", 123.5, 30),
            Product("AUDI A4", 85.5, 20),
            Product("KIA RIO", 50.5, 10)
        )
    )

    fun print() {
        var presentation = ""
        basket.products.forEach { p ->
            presentation +=
                "${p.name}: ${format(p.price)}/${p.discount}% = ${format(p.discountPrice)}\n"
        }
        presentation += format(basket.getDiscountPrice())
        viewState.print(presentation)
    }

    fun setOrderFirstName(s: String) {
        if (s.length > 2) {
            order.firstName = s
            viewState.showErrorFirstName(false)
        } else viewState.showErrorFirstName(true)
    }

    fun setOrderLastName(s: String) {
        if (s.length > 2) {
            order.lastName = s
            viewState.showErrorLastName(false)
        } else viewState.showErrorLastName(true)
    }

    fun setOrderFatherName(s: String) {
        if (s.length > 2) {
            order.fatherName = s
            viewState.showErrorFatherName(false)
        } else viewState.showErrorFatherName(true)
    }

    fun setOrderPhoneNumber(s: String) {
        if (Regex("(\\+7|8)\\d{10}").matches(s)) {
            order.phoneNumber = s
            viewState.showErrorPhoneNumber(false)
        } else viewState.showErrorPhoneNumber(true)
    }
}