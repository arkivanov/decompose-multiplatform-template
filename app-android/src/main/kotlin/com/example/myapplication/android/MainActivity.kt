package com.example.myapplication.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.arkivanov.decompose.defaultComponentContext
import com.example.myapplication.root.RootContent
import com.example.myapplication.shared.root.DefaultRootComponent

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val root = DefaultRootComponent(componentContext = defaultComponentContext())

        setContent {
            RootContent(component = root)
        }
    }
}
