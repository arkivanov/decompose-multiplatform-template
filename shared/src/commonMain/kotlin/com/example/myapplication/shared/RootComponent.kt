package com.example.myapplication.shared

import com.arkivanov.decompose.value.Value

interface RootComponent {

    val model: Value<Model>

    fun onUpdateGreetingText()

    data class Model(
        val greetingText: String = "Welcome from Decompose!"
    )
}
