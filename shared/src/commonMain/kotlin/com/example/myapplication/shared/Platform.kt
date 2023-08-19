package com.example.myapplication.shared

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform