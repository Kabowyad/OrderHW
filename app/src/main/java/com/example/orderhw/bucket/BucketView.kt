package com.example.orderhw.bucket

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface BucketView : MvpView {
    fun setItems(list: List<String>)
    fun removeItem(position: Int)
}