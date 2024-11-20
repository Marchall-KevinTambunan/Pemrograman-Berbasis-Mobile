package com.example.daftarmatakuliah

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.daftarmatakuliah.ui.MataKuliahDetailScreen
import com.example.daftarmatakuliah.ui.MataKuliahListScreen
import com.example.daftarmatakuliah.ui.theme.DaftarMataKuliahTheme

// Data class untuk menyimpan informasi Mata Kuliah
data class MataKuliah(val name: String, val description: String)

// MainActivity yang menjadi entry point aplikasi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Gunakan tema yang telah disiapkan
            DaftarMataKuliahTheme {
                // Permukaan utama aplikasi
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Memanggil composable utama
                    MataKuliahApp()
                }
            }
        }
    }
}

// Fungsi untuk menampilkan daftar dan detail mata kuliah
@Composable
fun MataKuliahApp() {
    var selectedMataKuliah by remember { mutableStateOf<MataKuliah?>(null) }

    if (selectedMataKuliah == null) {
        MataKuliahListScreen(onMataKuliahClick = { mataKuliah ->
            selectedMataKuliah = mataKuliah
        })
    } else {
        MataKuliahDetailScreen(
            mataKuliah = selectedMataKuliah!!,
            onBackClick = { selectedMataKuliah = null }
        )
    }
}

// Pratinjau antarmuka
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DaftarMataKuliahTheme {
        MataKuliahApp()
    }
}
