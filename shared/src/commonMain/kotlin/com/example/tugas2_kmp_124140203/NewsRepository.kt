package com.example.tugas2_kmp_124140203

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class NewsRepository {

    private val newsList = listOf(
        News(
            id = 1,
            title = "Teknologi AI Terus Berkembang",
            category = "Technology",
            content = "Perkembangan kecerdasan buatan semakin pesat."
        ),
        News(
            id = 2,
            title = "Tips Belajar Pemrograman",
            category = "Education",
            content = "Belajar pemrograman secara rutin dapat meningkatkan kemampuan."
        ),
        News(
            id = 3,
            title = "Perkembangan Gadget Terbaru",
            category = "Technology",
            content = "Berbagai perangkat baru hadir dengan teknologi yang semakin canggih."
        ),
        News(
            id = 4,
            title = "Kegiatan Kampus Minggu Ini",
            category = "Campus",
            content = "Berbagai kegiatan mahasiswa dilaksanakan di lingkungan kampus."
        ),
        News(
            id = 5,
            title = "Tips Menjaga Produktivitas",
            category = "Lifestyle",
            content = "Mengatur waktu dengan baik dapat membantu meningkatkan produktivitas."
        )
    )

    fun getNewsFlow(): Flow<News> = flow {
        for (news in newsList) {
            delay(2000)
            emit(news)
        }
    }

    fun getFormattedNewsFlow(): Flow<String> {
        return getNewsFlow().map { news ->
            """
            📰 ${news.title}
            Kategori: ${news.category}
            
            ${news.content}
            """.trimIndent()
        }
    }
}