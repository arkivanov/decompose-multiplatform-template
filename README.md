# Decompose Multiplatform Template

This is a Kotlin Multiplatform project template with [Decompose](https://github.com/arkivanov/decompose) configured.

> **Note**
> Due to the  [current state](https://github.com/arkivanov/Decompose/issues/74) of iOS support this template uses experimental versions of Decompose.
> If you have any issues, please report them on GitHub.

## About this Project

You can use this template to start developing your own
[Decompose](https://github.com/arkivanov/Decompose#readme) application targeting desktop,
Android, and iOS, either by using Compose as shared UI across all platforms, or by using
platform-specific UI like SwiftUI and Android XML.

The instructions below provide you additional information on how to work with this template and add
features like navigation, state preservation and more.

The result will be a [Kotlin Multiplatform](https://kotlinlang.org/docs/multiplatform.html) project
that uses the Decompose framework for common logic with the UI framework(s) of your choice and the
features you need.

This project was inspired by the [sample project of Decompose](https://github.com/arkivanov/Decompose/tree/master/sample)
and the [Compose Multiplatform Template](https://github.com/JetBrains/compose-multiplatform-template).

## Getting Started

In order to work with this template you need the following tools:
* [Android Studio](https://developer.android.com/studio)
* (Optional) The [Kotlin Multiplatform Mobile plugin](https://plugins.jetbrains.com/plugin/14936-kotlin-multiplatform-mobile)

Additionally, if you plan to write and run iOS-specific code on simulated or real devices, you need
the following:

* A machine running a recent version of macOS
* [Xcode](https://apps.apple.com/us/app/xcode/id497799835)

Tools like [KDoctor](https://github.com/Kotlin/kdoctor) can assist you during the installation
process.

## Project Structure

The project consists of multiple modules:

### `shared`

This is a Kotlin module that contains the shared logic of all platforms. This also includes the
Decompose implementation. 

### `compose-ui`

This is a Kotlin module that contains the UI written with Compose Multiplatform that is shared
across all platforms.

It depends on the `shared` module as it uses the component interfaces from Decompose.

### `app-desktop`

This is a Kotlin module that contains and builds the desktop (JVM) application.

It makes use of the shared code from the modules `shared` and `compose-ui`.

### `app-android`

This is a Kotlin module that contains and builds the Android mobile application.

It makes use of the shared code from the modules `shared` and `compose-ui`.

### `app-ios-compose`

This is an Xcode project that builds an iOS mobile application with Compose UI.

It makes use of the shared code from the modules `shared` and `compose-ui`.

### `app-ios-swift`

This is an Xcode project that builds an iOS mobile application with SwiftUI.

This module uses only the `shared` module and SwiftUI for its UI (instead of Compose).

> **Note**
> In practice you normally have either `app-ios-compose` or `app-ios-swift`.
> 
> Therefore, do not hesitate to merge them or delete one of the two. 

## Running the project

Depending on the platform you want to build for and run the project on, different gradle tasks may
be used.

### For Android

When using Android Studio you can simply select `app-android` from the run configurations and run
the app.

### For Desktop

```bash
./gradlew :app-desktop:run
```

### For iOS (Compose)

If you have installed the Kotlin Multiplatform Mobile plugin you can simply select `app-ios-compose`
from the run configurations and run the app.

Alternatively you can open `app-ios-compose/app-ios-compose.xcodeproj` in XCode and launch the project
from there.

### For iOS (Swift)

If you have installed the Kotlin Multiplatform Mobile plugin you can simply select `app-ios-swift`
from the run configurations and run the app.

Alternatively you can open `app-ios-swift/app-ios-swift.xcodeproj` in XCode and launch the project
from there.

## Further Reading

We encourage you to explore Decompose's features further and try adding them into your project:

* [Add basic navigation with child stack(s) to your project](https://arkivanov.github.io/Decompose/navigation/stack/overview/)
* [Add child slots for loading one child at a time, or none](https://arkivanov.github.io/Decompose/navigation/slot/overview/)
* [Add back button handlers for intercepting back button presses](https://arkivanov.github.io/Decompose/component/back-button/)

You can also have a look at various integrations, including:
* [State preservation with Essenty and Parcelize]() _(not available yet)_
* [Integration of MVIKotlin for sharing code using MVI pattern]() _(not available yet)_
