package com.example.praktikum6.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun Home(
    onDaftarClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(R.string.welcome_title),
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 4.dp)
        )
        Text(
            text = stringResource(R.string.welcome_subtitle),
            fontSize = 18.sp,
            modifier = Modifier.padding(bottom = 32.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.logo_cardlst), // Ganti sesuai nama file Anda
            contentDescription = "Logo Aplikasi",
            modifier = Modifier
                .size(120.dp)
                .padding(bottom = 24.dp)
        )
        Text(
            text = "${stringResource(R.string.nama_mahasiswa)} ${stringResource(R.string.nim_mahasiswa)}",
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(bottom = 32.dp)
        )
        // Tombol Submit
        Button(
            onClick = onDaftarClick,
            modifier = Modifier
                .width(200.dp)
                .height(50.dp)
        )








    }
}