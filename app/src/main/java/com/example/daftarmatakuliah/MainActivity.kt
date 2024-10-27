package com.example.daftarmatakuliah

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.daftarmatakuliah.ui.theme.DaftarMataKuliahTheme

data class MataKuliah(val name: String, val description: String)

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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MataKuliahListScreen(onMataKuliahClick: (MataKuliah) -> Unit) {
    val mataKuliahList = listOf(
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

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Daftar Mata Kuliah", fontSize = 20.sp, fontWeight = FontWeight.Bold) },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color(0xFF6200EA),
                    titleContentColor = Color.White
                )
            )
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            BackgroundImage()
            MataKuliahList(
                mataKuliahList = mataKuliahList,
                onItemClick = { mataKuliah ->
                    onMataKuliahClick(mataKuliah)
                }
            )
        }
    }
}

@Composable
fun MataKuliahList(mataKuliahList: List<MataKuliah>, onItemClick: (MataKuliah) -> Unit) {
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        items(mataKuliahList) { mataKuliah ->
            MataKuliahItem(
                mataKuliah = mataKuliah,
                onClick = { onItemClick(mataKuliah) }
            )
        }
    }
}

@Composable
fun MataKuliahItem(mataKuliah: MataKuliah, onClick: () -> Unit) {
    Card(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.buku1),
                contentDescription = "Gambar Buku",
                modifier = Modifier
                    .size(60.dp)
                    .padding(end = 8.dp),
                contentScale = ContentScale.Fit
            )
            Text(
                text = mataKuliah.name,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MataKuliahDetailScreen(mataKuliah: MataKuliah, onBackClick: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = mataKuliah.name,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color(0xFF3700B3)
                )
            )
        },
        bottomBar = {
            Button(
                onClick = onBackClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text("Kembali", fontSize = 16.sp)
            }
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.buku1),
                    contentDescription = "Gambar Buku",
                    modifier = Modifier
                        .size(150.dp)
                        .padding(bottom = 16.dp),
                    contentScale = ContentScale.Fit
                )
                Text(
                    text = mataKuliah.description,
                    fontSize = 18.sp,
                    lineHeight = 26.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(16.dp),
                    color = Color(0xFF333333)
                )
            }
        }
    }
}

@Composable
fun BackgroundImage() {
    Image(
        painter = painterResource(id = R.drawable.utdi),
        contentDescription = "Background Image",
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray),
        contentScale = ContentScale.Crop,
        alpha = 0.1f
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DaftarMataKuliahTheme {
        MataKuliahApp()
    }
}
