package com.example.daftarmatakuliah.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.daftarmatakuliah.MataKuliah

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MataKuliahDetailScreen(mataKuliah: MataKuliah, onBackClick: () -> Unit) {
    // Scaffold digunakan untuk membuat layout dasar dengan appBar dan bottomBar
    Scaffold(
        topBar = {
            // TopAppBar digunakan untuk menampilkan judul halaman mata kuliah
            TopAppBar(
                title = {
                    Text(
                        text = mataKuliah.name,  // Menampilkan nama mata kuliah di judul
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White  // Warna teks judul
                    )
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color(0xFF3700B3)  // Warna latar belakang TopAppBar
                )
            )
        },
        bottomBar = {
            // Button di bagian bawah untuk navigasi kembali ke layar sebelumnya
            Button(
                onClick = onBackClick,  // Fungsi untuk menangani aksi klik pada tombol kembali
                modifier = Modifier
                    .fillMaxWidth()  // Membuat tombol lebar penuh
                    .padding(16.dp)  // Memberikan padding di sekitar tombol
            ) {
                Text("Kembali", fontSize = 16.sp)  // Menampilkan teks "Kembali" pada tombol
            }
        }
    ) {
        // Box digunakan untuk menempatkan konten di dalamnya dan memastikan pemusatan
        Box(
            modifier = Modifier
                .fillMaxSize()  // Membuat Box mengisi seluruh layar
                .padding(it),  // Memberikan padding untuk menghindari pemotongan oleh Scaffold
            contentAlignment = Alignment.Center  // Menempatkan konten di tengah
        ) {
            // Column digunakan untuk menampilkan konten secara vertikal
            Column(
                modifier = Modifier
                    .fillMaxSize()  // Membuat Column mengisi seluruh layar
                    .padding(24.dp),  // Memberikan padding pada kolom
                horizontalAlignment = Alignment.CenterHorizontally  // Menyusun konten di tengah horizontal
            ) {
                // Menampilkan deskripsi mata kuliah
                Text(
                    text = mataKuliah.description,  // Menampilkan deskripsi mata kuliah
                    fontSize = 18.sp,
                    lineHeight = 26.sp,  // Mengatur tinggi baris untuk teks deskripsi
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(16.dp),  // Memberikan padding pada teks
                    color = Color(0xFF333333)  // Warna teks deskripsi
                )
            }
        }
    }
}
