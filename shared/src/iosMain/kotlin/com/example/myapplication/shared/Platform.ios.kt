package com.example.myapplication.shared

import platform.UIKit.UIDevice

actual fun getPlatformName(): String =
    "${UIDevice.currentDevice.systemName()} ${UIDevice.currentDevice.systemVersion}"