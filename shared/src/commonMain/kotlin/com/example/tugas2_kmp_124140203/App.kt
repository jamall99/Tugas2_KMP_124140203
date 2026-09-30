package com.example.tugas2_kmp_124140203

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun App() {

    val repository = remember {
        NewsRepository()
    }

    val newsState = remember {
        NewsState()
    }

    val newsDetail = remember {
        NewsDetail()
    }

    val readCount by newsState.readCount.collectAsState()

    var currentNews by remember {
        mutableStateOf<News?>(null)
    }

    var allNews by remember {
        mutableStateOf<List<News>>(emptyList())
    }

    var selectedCategory by remember {
        mutableStateOf("All")
    }

    var detailNews by remember {
        mutableStateOf<News?>(null)
    }

    var detailText by remember {
        mutableStateOf("")
    }

    // Flow untuk menerima berita setiap 2 detik
    LaunchedEffect(Unit) {
        repository.getNewsFlow().collect { news ->
            currentNews = news
            allNews = allNews + news
        }
    }

    // Coroutine untuk mengambil detail berita
    LaunchedEffect(detailNews) {
        if (detailNews != null) {
            detailText = "Loading detail..."

            detailText = newsDetail.loadDetail(detailNews!!)
        }
    }

    val newsToShow = if (selectedCategory == "All") {
        currentNews
    } else {
        allNews.lastOrNull {
            it.category == selectedCategory
        }
    }

    MaterialTheme {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "News Feed Simulator",
                style = MaterialTheme.typography.headlineMedium
            )

            Text(
                text = "Berita sudah dibaca: $readCount",
                modifier = Modifier.padding(top = 8.dp)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {

                Button(
                    onClick = {
                        selectedCategory = "All"
                    }
                ) {
                    Text("All")
                }

                Button(
                    onClick = {
                        selectedCategory = "Technology"
                    }
                ) {
                    Text("Technology")
                }

                Button(
                    onClick = {
                        selectedCategory = "Education"
                    }
                ) {
                    Text("Education")
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {

                Button(
                    onClick = {
                        selectedCategory = "Campus"
                    }
                ) {
                    Text("Campus")
                }

                Button(
                    onClick = {
                        selectedCategory = "Lifestyle"
                    }
                ) {
                    Text("Lifestyle")
                }
            }

            if (newsToShow != null) {

                val formattedNews = """
                    📰 ${newsToShow.title}
                    
                    Kategori: ${newsToShow.category}
                    
                    ${newsToShow.content}
                """.trimIndent()

                Text(
                    text = formattedNews,
                    modifier = Modifier.padding(top = 24.dp)
                )

                Button(
                    onClick = {
                        newsState.markAsRead()
                    },
                    modifier = Modifier.padding(top = 16.dp)
                ) {
                    Text("Tandai Dibaca")
                }

                Button(
                    onClick = {
                        detailNews = newsToShow
                    },
                    modifier = Modifier.padding(top = 8.dp)
                ) {
                    Text("Lihat Detail")
                }
            }

            if (detailText.isNotEmpty()) {

                Text(
                    text = detailText,
                    modifier = Modifier.padding(top = 24.dp)
                )
            }
        }
    }
}