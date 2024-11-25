package com.example.daftarmatakuliah

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.daftarmatakuliah.navigation.NavGraph
import com.example.daftarmatakuliah.ui.theme.DaftarMataKuliahTheme

// Data class untuk menyimpan informasi Mata Kuliah
data class MataKuliah(val name: String, val description: String)

// MainActivity sebagai entry point aplikasi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DaftarMataKuliahTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MataKuliahApp()
                }
            }
        }
    }
}

// Fungsi utama aplikasi dengan navigasi
@Composable
fun MataKuliahApp() {
    val navController = rememberNavController()
    NavGraph(navController = navController)
}

// Pratinjau antarmuka
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DaftarMataKuliahTheme {
        MataKuliahApp()
    }
}
