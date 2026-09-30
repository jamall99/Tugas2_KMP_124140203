package com.example.tugas2_kmp_124140203

import kotlinx.coroutines.delay

class NewsDetail {

    suspend fun loadDetail(news: News): String {
        delay(1000)

        return """
            Detail Berita

            📰 ${news.title}
            Kategori: ${news.category}

            ${news.content}
        """.trimIndent()
    }
}