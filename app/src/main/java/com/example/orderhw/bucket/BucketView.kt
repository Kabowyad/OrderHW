package com.example.orderhw.bucket

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface BucketView : MvpView {
    fun setItems(list: List<String>)
    fun removeItem(position: Int)
}