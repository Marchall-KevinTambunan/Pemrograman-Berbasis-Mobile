package com.example.daftarmatakuliah.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.daftarmatakuliah.MataKuliah
import com.example.daftarmatakuliah.R
import com.example.daftarmatakuliah.ui.viewmodel.MataKuliahViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MataKuliahListScreen(
    onMataKuliahClick: (MataKuliah) -> Unit,
    mataKuliahViewModel: MataKuliahViewModel = viewModel() // Menggunakan viewModel() untuk mendapatkan data dari ViewModel
) {
    // Mendapatkan daftar mata kuliah dari ViewModel
    val mataKuliahList = mataKuliahViewModel.mataKuliahList

    // Scaffold adalah struktur dasar layout di Compose, di sini digunakan untuk menampilkan topAppBar dan body
    Scaffold(
        topBar = {
            // TopAppBar untuk menampilkan judul layar
            TopAppBar(
                title = { Text("Daftar Mata Kuliah", fontSize = 20.sp, fontWeight = FontWeight.Bold) },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color(0xFF6200EA), // Warna background topAppBar
                    titleContentColor = Color.White // Warna teks judul
                )
            )
        }
    ) {
        // Box digunakan untuk membungkus isi konten dan menambahkan padding dari Scaffold
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it) // Padding untuk mengakomodasi area konten Scaffold
        ) {
            // Memanggil fungsi MataKuliahList untuk menampilkan daftar mata kuliah
            MataKuliahList(
                mataKuliahList = mataKuliahList,
                onItemClick = { mataKuliah ->
                    // Callback ketika sebuah mata kuliah dipilih
                    onMataKuliahClick(mataKuliah)
                }
            )
        }
    }
}

@Composable
fun MataKuliahList(mataKuliahList: List<MataKuliah>, onItemClick: (MataKuliah) -> Unit) {
    // LazyColumn digunakan untuk menampilkan daftar dengan pengoptimalan memori (hanya item yang terlihat yang dimuat)
    LazyColumn(
        contentPadding = PaddingValues(16.dp), // Memberikan padding di sekitar daftar
        verticalArrangement = Arrangement.spacedBy(12.dp), // Spasi antar item
        modifier = Modifier.fillMaxSize() // Menggunakan ukuran penuh untuk LazyColumn
    ) {
        // Mengiterasi semua mata kuliah dan menampilkan item untuk setiap mata kuliah
        items(mataKuliahList) { mataKuliah ->
            // Memanggil MataKuliahItem untuk setiap mata kuliah
            MataKuliahItem(
                mataKuliah = mataKuliah,
                onClick = { onItemClick(mataKuliah) } // Callback saat item diklik
            )
        }
    }
}

@Composable
fun MataKuliahItem(mataKuliah: MataKuliah, onClick: () -> Unit) {
    // Card untuk menampilkan informasi tentang mata kuliah
    Card(
        onClick = onClick, // Mengaktifkan aksi saat Card diklik
        modifier = Modifier
            .fillMaxWidth() // Mengatur lebar Card sesuai lebar layar
            .height(80.dp), // Tinggi Card
        colors = CardDefaults.cardColors(containerColor = Color.White), // Warna latar belakang Card
        elevation = CardDefaults.cardElevation(6.dp) // Memberikan efek bayangan pada Card
    ) {
        // Row untuk menampilkan konten secara horizontal (gambar dan teks)
        Row(
            verticalAlignment = Alignment.CenterVertically, // Vertikal di tengah
            modifier = Modifier
                .fillMaxSize() // Mengisi ruang yang tersedia
                .padding(8.dp) // Padding di dalam Row
        ) {
            // Gambar buku untuk setiap mata kuliah
            Image(
                painter = painterResource(id = R.drawable.buku1), // Resource gambar
                contentDescription = "Gambar Buku", // Deskripsi gambar
                modifier = Modifier
                    .size(60.dp) // Ukuran gambar
                    .padding(end = 8.dp), // Padding di sebelah kanan gambar
                contentScale = ContentScale.Fit // Menyesuaikan gambar dengan ukuran yang sesuai
            )
            // Menampilkan nama mata kuliah
            Text(
                text = mataKuliah.name,
                fontSize = 18.sp, // Ukuran font
                fontWeight = FontWeight.Medium // Ketebalan font
            )
        }
    }
}
