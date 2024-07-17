package com.example.myapplication.shared.root

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.example.myapplication.shared.main.PreviewMainComponent
import com.example.myapplication.shared.root.RootComponent.Child

object PreviewRootComponent : RootComponent {

    private val navigation = StackNavigation<Unit>()

    override val stack: Value<ChildStack<*, Child>> =
        MutableValue(
            ChildStack(
                configuration = navigation,
                instance = Child.Main(PreviewMainComponent),
            )
        )

    override fun onBackClicked(toIndex: Int) {}
}
