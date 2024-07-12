package com.example.myapplication.shared.welcome

import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.update
import com.example.myapplication.shared.getPlatformName
import com.example.myapplication.shared.welcome.WelcomeComponent.Model

/**
 * Parameter-less constructor component used for previewing.
 */
class PreviewWelcomeComponent : WelcomeComponent {
  override val model = MutableValue(Model())

  override fun onUpdateGreetingText() {
    model.update { it.copy(greetingText = "Welcome from ${getPlatformName()}") }
  }

  override fun onBackClicked() = Unit
}
