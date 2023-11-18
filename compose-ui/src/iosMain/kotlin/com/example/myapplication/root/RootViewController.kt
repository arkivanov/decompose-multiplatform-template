package com.example.myapplication.root

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.ComposeUIViewController
import com.example.myapplication.root.RootContent
import com.example.myapplication.shared.root.RootComponent
import platform.UIKit.UIViewController

fun rootViewController(root: RootComponent): UIViewController =
    ComposeUIViewController {
        RootContent(component = root, modifier = Modifier.fillMaxSize())
    }
