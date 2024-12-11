package com.example.daftarmatakuliah.data

import com.example.daftarmatakuliah.MataKuliah

class MataKuliahRepository {
    // Simulasi data sementara
    private val mataKuliahList = listOf(
        MataKuliah(
            "Pemrograman Berbasis Mobile",
            "Mata kuliah Pemrograman Mobile membahas tentang dasar-dasar pengembangan aplikasi android, " +
                    "meliputi menyiapkan lingkungan development aplikasi android, membuat, menguji dan men-debug aplikasi; " +
                    "membuat antarmuka pengguna responsif serta adaptif yang bekerja pada berbagai perangkat; " +
                    "melakukan tugas yang berjalan-lama dan pekerjaan latar belakang dalam aplikasi Android; " +
                    "menyimpan, berbagi dan mengambil data dalam aplikasi Android; mempelajari bagaimana perizinan, " +
                    "keamanan dan kinerja memengaruhi aplikasi, mempelajari cara monetisasi aplikasi, mempelajari cara mempublikasikan aplikasi."
        ),
        MataKuliah(
            "Bahasa Inggris 3",
            "Mata kuliah Bahasa Inggris III ini membahas tentang integrasi empat kemampuan dasar berbahasa Inggris yaitu berbicara (speaking), " +
                    "mendengarkan (listening), membaca (reading), dan menulis (writing) termasuk aspek-aspek tata bahasa dan kosakata " +
                    "ke dalam ruang lingkup pelayanan dan pekerjaan keperawatan baik dalam praktik klinik/komunitas maupun pada pembelajaran di dalam kelas."
        ),
        MataKuliah(
            "Data Mining",
            "Mata kuliah ini membahas mengenai konsep Data Mining, pemrosesan awal data, pemodelan, serta pengklasifikasian data mining. " +
                    "Konsep data mining meliputi pengertian data mining, peran data mining dalam berbagai ilmu, jenis set data, " +
                    "dan ukuran kemiripan dan ketidakmiripan data."
        ),
        MataKuliah(
            "Teknologi Cloud",
            "Cloud computing adalah penyediaan sumber daya komputasi seperti server, penyimpanan data, jaringan, dan perangkat lunak melalui internet. " +
                    "Cloud computing, disebut juga komputasi awan, merupakan gabungan dari penggunaan teknologi komputer (“komputasi”) " +
                    "dan pengembangan berbasis internet (“cloud” atau “awan”)."
        ),
        MataKuliah(
            "Infrastruktur Big Data",
            "Proses memeriksa sejumlah besar data. Terdapat sejumlah besar data digital yang heterogen. " +
                    "Big Data adalah tentang volume data dan kumpulan data besar yang diukur dalam terabyte atau petabyte."
        ),
        MataKuliah(
            "Manajemen Proyek",
            "Mata kuliah ini memberikan pemahaman pada mahasiswa tentang bagaimana prinsip dasar pengelolaan sebuah proyek, " +
                    "tahapan, serta memahami bagaimana sebuah proyek dikatakan sukses dilihat dari pemenuhan kebutuhan utama proyek."
        ),
        MataKuliah(
            "Pendidikan Bahasa Indonesia",
            "Pendidikan bahasa dan sastra Indonesia adalah bidang pendidikan yang berpusat pada pembelajaran dan pengajaran " +
                    "tentang ilmu linguistik, seperti morfologi, fonologi, semantik, dan sebagainya, serta materi tentang kesusastraan " +
                    "mulai dari apresiasi hingga pengkajian karya sastra."
        ),
        MataKuliah(
            "Pengenalan Pola",
            "Pengenalan pola (dalam bahasa Inggris: pattern recognition) merupakan bidang dalam pembelajaran mesin dan dapat " +
                    "diartikan sebagai 'tindakan mengambil data mentah dan bertindak berdasarkan klasifikasi data'."
        ),
        MataKuliah(
            "Proyek Pengembangan Aplikasi Web",
            "Pengembangan aplikasi web adalah proses penting untuk membuat aplikasi perangkat lunak yang berfungsi melalui browser web, " +
                    "menawarkan kompatibilitas lintas platform kepada pengguna dan beradaptasi dengan aplikasi seluler untuk akses tanpa batas di seluruh perangkat."
        )
    )
    // Fungsi untuk mendapatkan semua data mata kuliah
    fun getAllMataKuliah(): List<MataKuliah> = mataKuliahList
}
