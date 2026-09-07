package com.example.tugas1_kmp_124140203

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform