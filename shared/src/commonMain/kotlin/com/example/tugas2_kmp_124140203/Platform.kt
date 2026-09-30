package com.example.tugas2_kmp_124140203

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform