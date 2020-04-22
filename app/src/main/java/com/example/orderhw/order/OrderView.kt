package com.example.orderhw.order

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface OrderView : MvpView {
    fun print(msg: String)
    fun showErrorFirstName(visible: Boolean)
    fun showErrorLastName(visible: Boolean)
    fun showErrorFatherName(visible: Boolean)
    fun showErrorPhoneNumber(visible: Boolean)
}