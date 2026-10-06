package com.example.tugas2_kmp_124140203

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import com.example.tugas2_kmp_124140203.resources.Res
import com.example.tugas2_kmp_124140203.resources.saya


@Composable
fun App() {

    MaterialTheme {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            ProfileHeader()

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Mahasiswa Teknik Informatika yang sedang belajar dan mengembangkan kemampuan di bidang teknologi.",
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(16.dp))

            ProfileCard()

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    // Tombol belum memiliki aksi khusus
                }
            ) {
                Text("Hubungi Saya")
            }
        }
    }
}


@Composable
fun ProfileHeader() {

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Box(
            modifier = Modifier
                .size(90.dp)
                .clip(CircleShape),
            contentAlignment = Alignment.Center
        ) {

            Image(
                painter = painterResource(Res.drawable.saya),
                contentDescription = "Foto profil",
                modifier = Modifier
                    .fillMaxSize()
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
        }

        Spacer(modifier = Modifier.size(16.dp))

        Column {

            Text(
                text = "Yayan Sofhian",
                style = MaterialTheme.typography.headlineSmall
            )

            Text(
                text = "Teknik Informatika",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}


@Composable
fun ProfileCard() {

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Text(
                text = "Informasi Kontak",
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(12.dp))

            InfoItem(
                label = "Email",
                value = "yayan123@gmail.com"
            )

            InfoItem(
                label = "Phone",
                value = "089517933678"
            )

            InfoItem(
                label = "Location",
                value = "Lampung, Indonesia"
            )
        }
    }
}


@Composable
fun InfoItem(
    label: String,
    value: String
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Text(
            text = label,
            style = MaterialTheme.typography.bodyLarge
        )

        Text(
            text = value,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}