package com.example.praktikum6.view

import androidx.compose.runtime.Composable


@Composable
fun Tampildata(
    daftarPendaftar: List<Pendaftar>,
    onBackToHome: () -> Unit,
    onGoToForm: () -> Unit
)