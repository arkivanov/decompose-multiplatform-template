package com.example.myapplication.shared

actual fun getPlatformName(): String = "Android ${android.os.Build.VERSION.SDK_INT}"