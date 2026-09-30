package com.example.tugas1_kmp_124140203

import android.os.Build
import com.example.tugas2_kmp_124140203.Platform

class AndroidPlatform : Platform {
    override val name: String = "Android ${Build.VERSION.SDK_INT}"
}

actual fun getPlatform(): Platform = AndroidPlatform()