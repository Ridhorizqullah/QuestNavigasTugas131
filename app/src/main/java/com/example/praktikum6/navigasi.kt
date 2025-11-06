package com.example.praktikum6

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.praktikum6.view.FormPendaftaranPage
import com.example.praktikum6.view.Home
import com.example.praktikum6.view.Tampildata

// Model data
data class Pendaftar(
    val nama: String,
    val jenisKelamin: String,
    val status: String,
    val alamat: String
)

@Composable
fun Praktikum6App() {
    val navController = rememberNavController()
    val daftarPendaftar = remember { mutableStateListOf<Pendaftar>() }

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            Home(
                onDaftarClick = { navController.navigate("form") },
                onLihatDaftarClick = { navController.navigate("list") }
            )
        }
        composable("form") {
            FormPendaftaranPage(
                onSimpan = { nama, jk, status, alamat ->
                    daftarPendaftar.add(Pendaftar(nama, jk, status, alamat))
                    navController.navigate("list")
                },
                onBack = { navController.popBackStack() }
            )
        }
        composable("list") {
            Tampildata(
                daftarPendaftar = daftarPendaftar,
                onBackToHome = { navController.navigate("home") },
                onGoToForm = { navController.navigate("form") }
            )
        }
    }
}