package com.example.myapplication.shared

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.arkivanov.decompose.value.update
import com.example.myapplication.shared.RootComponent.Model

class DefaultRootComponent(
    componentContext: ComponentContext,
): RootComponent, ComponentContext by componentContext {

    // Consider preserving and managing the state via a store
    private val state = MutableValue(Model())
    override val model: Value<Model> = state

    override fun onUpdateGreetingText() {
        state.update { it.copy(greetingText = "Welcome from ${getPlatformName()}") }
    }
}
