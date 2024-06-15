package com.example.myapplication

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.extensions.compose.pages.Pages
import com.arkivanov.decompose.extensions.compose.pages.PagesScrollAnimation
import com.arkivanov.decompose.router.pages.ChildPages

@OptIn(ExperimentalFoundationApi::class, ExperimentalDecomposeApi::class)
@Composable
fun FailingComposable() {
    Pages(
        pages = ChildPages(items = emptyList(), selectedIndex = 0),
        onPageSelected = {},
        scrollAnimation = PagesScrollAnimation.Default, // Commenting this line fixes the error
    ) { index, _ ->
        Text("Item: $index")
    }
}
