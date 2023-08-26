package com.example.myapplication.shared
actual fun getPlatformName(): String = "Desktop ${System.getProperty("os.name")}"
