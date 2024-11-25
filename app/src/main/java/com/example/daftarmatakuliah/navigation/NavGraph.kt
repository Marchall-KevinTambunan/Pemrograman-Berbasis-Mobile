package com.example.daftarmatakuliah.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.daftarmatakuliah.ui.MataKuliahDetailScreen
import com.example.daftarmatakuliah.ui.MataKuliahListScreen
import com.example.daftarmatakuliah.ui.viewmodel.MataKuliahViewModel

@Composable
fun NavGraph(navController: NavHostController) {
    // Mendapatkan instance ViewModel yang berisi daftar mata kuliah
    val mataKuliahViewModel: MataKuliahViewModel = viewModel()
    val mataKuliahList = mataKuliahViewModel.mataKuliahList // Daftar mata kuliah dari ViewModel

    // NavHost adalah container utama untuk mendefinisikan navigasi di aplikasi
    NavHost(
        navController = navController, // Controller navigasi untuk berpindah layar
        startDestination = "list" // Layar awal ketika aplikasi dijalankan
    ) {
        // Definisi layar daftar mata kuliah
        composable("list") {
            // Panggil layar MataKuliahListScreen dengan callback ketika item diklik
            MataKuliahListScreen(onMataKuliahClick = { mataKuliah ->
                // Cari indeks mata kuliah yang dipilih berdasarkan nama
                val mataKuliahIndex = mataKuliahList.indexOfFirst { it.name == mataKuliah.name }

                if (mataKuliahIndex >= 0) {
                    // Navigasi ke layar detail dengan menyertakan indeks mata kuliah
                    navController.navigate("detail/$mataKuliahIndex")
                } else {
                    // Jika mata kuliah tidak ditemukan, log error
                    Log.e("NavGraph", "Mata kuliah tidak ditemukan: ${mataKuliah.name}")
                }
            })
        }

        // Definisi layar detail mata kuliah
        composable(
            route = "detail/{mataKuliahIndex}", // Rute dengan parameter mataKuliahIndex
            arguments = listOf(navArgument("mataKuliahIndex") { defaultValue = -1 }) // Definisi argumen dengan nilai default
        ) { backStackEntry ->
            // Ambil nilai parameter mataKuliahIndex dari argumen navigasi
            val mataKuliahIndex = backStackEntry.arguments?.getInt("mataKuliahIndex") ?: -1

            if (mataKuliahIndex in mataKuliahList.indices) {
                // Jika indeks valid, ambil data mata kuliah yang sesuai
                val mataKuliah = mataKuliahList[mataKuliahIndex]
                // Tampilkan layar detail mata kuliah dengan data yang sesuai
                MataKuliahDetailScreen(
                    mataKuliah = mataKuliah, // Data mata kuliah yang ditampilkan
                    onBackClick = { navController.popBackStack() } // Callback untuk kembali ke layar sebelumnya
                )
            } else {
                // Jika indeks tidak valid, log error
                Log.e("NavGraph", "Invalid mataKuliahIndex: $mataKuliahIndex")
            }
        }
    }
}
