package com.example.praktikum6.view

import androidx.compose.runtime.Composable

@Composable
fun FormPendaftaranPage(
    onback: () -> Unit
){
    val context = LocalContext.current

    var namaLengkap by remember { mutableStateOf("") }
    var jenisKelamin by remember { mutableStateOf("") }
    var statusPerkawinan by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }

    var namaError by remember { mutableStateOf(false) }
    var alamatError by remember { mutableStateOf(false) }

    val jenisKelaminOptions = listOf("Laki-laki", "Perempuan")
    val statusPerkawinanOptions = listOf("Janda", "Lajang", "Duda")




}