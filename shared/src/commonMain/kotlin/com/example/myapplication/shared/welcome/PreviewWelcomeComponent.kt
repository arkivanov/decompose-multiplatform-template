package com.example.myapplication.shared.welcome

import com.arkivanov.decompose.value.MutableValue
import com.example.myapplication.shared.welcome.WelcomeComponent.Model

object PreviewWelcomeComponent : WelcomeComponent {
  override val model = MutableValue(Model())

  override fun onUpdateGreetingText() {}

  override fun onBackClicked() {}
}
