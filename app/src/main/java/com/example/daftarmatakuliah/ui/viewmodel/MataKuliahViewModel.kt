package com.example.daftarmatakuliah.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.daftarmatakuliah.MataKuliah
import com.example.daftarmatakuliah.data.MataKuliahRepository

class MataKuliahViewModel : ViewModel() {
    private val repository = MataKuliahRepository()

    // Mendapatkan daftar mata kuliah dari repository
    val mataKuliahList: List<MataKuliah> = repository.getAllMataKuliah()
}
