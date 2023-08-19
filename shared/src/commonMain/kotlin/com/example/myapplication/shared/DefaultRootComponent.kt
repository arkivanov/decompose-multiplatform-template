package com.example.myapplication.shared

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.arkivanov.decompose.value.update

class DefaultRootComponent(
    componentContext: ComponentContext,
): RootComponent, ComponentContext by componentContext {

    // Consider preserving and managing the state via a store
    private val state = MutableValue(RootComponent.Model())
    override val model: Value<RootComponent.Model> = state

    override fun onUpdateGreetingText() {
        state.update { it.copy(greetingText = "Welcome from ${getPlatform().name}") }
    }
}
