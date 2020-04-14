package com.example.orderhw

interface View {
    fun print(msg: String)
}

class ConsoleView : View {
    override fun print(msg: String) = println(msg)
}