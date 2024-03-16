package com.example.myapplication.shared.root

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.popTo
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.decompose.value.Value
import com.example.myapplication.shared.main.DefaultMainComponent
import com.example.myapplication.shared.main.MainComponent
import com.example.myapplication.shared.root.RootComponent.Child
import com.example.myapplication.shared.welcome.DefaultWelcomeComponent
import com.example.myapplication.shared.welcome.WelcomeComponent
import kotlinx.serialization.Serializable

class DefaultRootComponent(
    componentContext: ComponentContext,
) : RootComponent, ComponentContext by componentContext {

    private val navigation = StackNavigation<Config>()

    override val stack: Value<ChildStack<*, Child>> =
        childStack(
            source = navigation,
            serializer = Config.serializer(),
            initialConfiguration = Config.Main,
            handleBackButton = true,
            childFactory = ::child,
        )

    private fun child(config: Config, childComponentContext: ComponentContext): Child =
        when (config) {
            is Config.Main -> Child.Main(mainComponent(childComponentContext))
            is Config.Welcome -> Child.Welcome(welcomeComponent(childComponentContext))
        }

    private fun mainComponent(componentContext: ComponentContext): MainComponent =
        DefaultMainComponent(
            componentContext = componentContext,
            onShowWelcome = { navigation.push(Config.Welcome) },
        )

    private fun welcomeComponent(componentContext: ComponentContext): WelcomeComponent =
        DefaultWelcomeComponent(
            componentContext = componentContext,
            onFinished = navigation::pop,
        )

    override fun onBackClicked(toIndex: Int) {
        navigation.popTo(index = toIndex)
    }

    @Serializable
    private sealed interface Config {
        @Serializable
        data object Main : Config

        @Serializable
        data object Welcome : Config
    }
}
