package com.example.daftarmatakuliah.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.daftarmatakuliah.MataKuliah

@Composable
fun MataKuliahApp() {
    // Menggunakan remember dan mutableStateOf untuk menyimpan dan mengubah state terpilih
    var selectedMataKuliah by remember { mutableStateOf<MataKuliah?>(null) }

    // Memeriksa apakah mata kuliah terpilih (selectedMataKuliah) null atau tidak
    if (selectedMataKuliah == null) {
        // Jika mata kuliah belum dipilih, tampilkan daftar mata kuliah
        MataKuliahListScreen(onMataKuliahClick = { mataKuliah ->
            // Saat sebuah mata kuliah dipilih, perbarui selectedMataKuliah dengan mata kuliah yang dipilih
            selectedMataKuliah = mataKuliah
        })
    } else {
        // Jika mata kuliah sudah dipilih, tampilkan detail mata kuliah yang dipilih
        MataKuliahDetailScreen(
            mataKuliah = selectedMataKuliah!!,  // Mata kuliah yang dipilih dipass ke MataKuliahDetailScreen
            onBackClick = { selectedMataKuliah = null }  // Fungsi untuk kembali ke daftar mata kuliah
        )
    }
}
