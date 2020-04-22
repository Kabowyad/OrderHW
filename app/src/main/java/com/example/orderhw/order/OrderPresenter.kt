package com.example.orderhw.order

import com.example.orderhw.Presenter
import com.example.orderhw.bucket.Bucket
import com.example.orderhw.format

class OrderPresenter(
    private val bucket: Bucket,
    private val order: Order
) : Presenter() {
    override fun print() {
        var presentation = ""
        bucket.products.forEach { p ->
            presentation += "${p.name}: ${format(
                p.price
            )}/${p.salePercent}% = ${format(
                p.discountPrice
            )}\n"
        }
        presentation += format(
            bucket.discountPrice
        )
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