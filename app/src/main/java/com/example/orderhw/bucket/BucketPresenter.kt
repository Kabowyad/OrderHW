package com.example.orderhw.bucket

import moxy.MvpPresenter

class BucketPresenter : MvpPresenter<BucketView>() {
    private val list = mutableListOf("Item 1", "Item 2", "Item 3")

    fun setItems() = viewState.setItems(list)

    fun removeItem(name: String) {
        val position = list.indexOf(name)
        list.removeAt(position)
        viewState.removeItem(position)
    }
}