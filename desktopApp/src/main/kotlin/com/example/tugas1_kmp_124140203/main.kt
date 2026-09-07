package com.example.tugas1_kmp_124140203

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Tugas1_KMP_124140203",
    ) {
        App()
    }
}