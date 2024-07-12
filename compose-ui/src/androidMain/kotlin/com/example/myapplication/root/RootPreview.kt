package com.example.myapplication.root

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import com.example.myapplication.shared.root.DefaultRootComponent

/**
 * This preview can support navigation.
 * (Use the default Android Studio @Preview function).
 */
@Preview
@Composable
fun RootPreview() {
  RootContent(
    DefaultRootComponent(
      componentContext = DefaultComponentContext(
        lifecycle = LifecycleRegistry()
      )
    )
  )
}
