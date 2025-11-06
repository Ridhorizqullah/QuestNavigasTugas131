package com.example.praktikum6.view

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.praktikum6.R

@Composable
fun FormPendaftaranPage(
    onSimpan: (String, String, String, String) -> Unit,
    onBack: () -> Unit
) {
    val context = LocalContext.current

    var namaLengkap by remember { mutableStateOf("") }
    var jenisKelamin by remember { mutableStateOf("") }
    var statusPerkawinan by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }

    var showPopup by remember { mutableStateOf(false) }

    val jenisKelaminOptions = listOf("Laki-laki", "Perempuan")
    val statusPerkawinanOptions = listOf("Janda", "Lajang", "Duda")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF3E5F5))
    ) {
        // Header
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(Color(0xFFCE93D8))
                .padding(horizontal = 24.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = onBack, modifier = Modifier.size(40.dp)) {
                    Icon(
                        imageVector = androidx.compose.material.icons.Icons.Default.ArrowBack,
                        contentDescription = "Kembali",
                        tint = Color.White
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = stringResource(R.string.form_title),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Form Card
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            shape = RoundedCornerShape(12.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                // Nama
                Column {
                    Text(
                        text = stringResource(R.string.label_nama),
                        fontSize = 12.sp,
                        color = Color.Gray,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    OutlinedTextField(
                        value = namaLengkap,
                        onValueChange = { namaLengkap = it },
                        placeholder = { Text(stringResource(R.string.hint_nama)) },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(8.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            unfocusedBorderColor = Color(0xFFB39DDB),
                            focusedBorderColor = Color(0xFF9C27B0)
                        ),
                        singleLine = true
                    )
                }

                // Jenis Kelamin
                Column {
                    Text(
                        text = stringResource(R.string.label_jenis_kelamin),
                        fontSize = 12.sp,
                        color = Color.Gray,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    jenisKelaminOptions.forEach { option ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .selectable(
                                    selected = jenisKelamin == option,
                                    onClick = { jenisKelamin = option }
                                )
                                .padding(vertical = 8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RadioButton(
                                selected = jenisKelamin == option,
                                onClick = { jenisKelamin = option },
                                colors = RadioButtonDefaults.colors(selectedColor = Color(0xFF9C27B0))
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(text = option, fontSize = 16.sp)
                        }
                    }
                }

                // Status Perkawinan
                Column {
                    Text(
                        text = stringResource(R.string.label_status),
                        fontSize = 12.sp,
                        color = Color.Gray,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    statusPerkawinanOptions.forEach { option ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .selectable(
                                    selected = statusPerkawinan == option,
                                    onClick = { statusPerkawinan = option }
                                )
                                .padding(vertical = 8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RadioButton(
                                selected = statusPerkawinan == option,
                                onClick = { statusPerkawinan = option },
                                colors = RadioButtonDefaults.colors(selectedColor = Color(0xFF9C27B0))
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(text = option, fontSize = 16.sp)
                        }
                    }
                }

                // Alamat
                Column {
                    Text(
                        text = "ALAMAT",
                        fontSize = 12.sp,
                        color = Color.Gray,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    OutlinedTextField(
                        value = alamat,
                        onValueChange = { alamat = it },
                        placeholder = { Text("Alamat") },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(8.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            unfocusedBorderColor = Color(0xFFB39DDB),
                            focusedBorderColor = Color(0xFF9C27B0)
                        ),
                        singleLine = true
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Tombol Submit
                Button(
                    onClick = {
                        if (namaLengkap.isEmpty() || jenisKelamin.isEmpty() ||
                            statusPerkawinan.isEmpty() || alamat.isEmpty()
                        ) {
                            Toast.makeText(context, "Semua field wajib diisi", Toast.LENGTH_SHORT)
                                .show()
                        } else {
                            onSimpan(namaLengkap, jenisKelamin, statusPerkawinan, alamat)
                            showPopup = true
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp),
                    shape = RoundedCornerShape(24.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF9C27B0))
                ) {
                    Text(
                        text = "Submit",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
            }
        }

        // Popup Alert
        if (showPopup) {
            AlertDialog(
                onDismissRequest = { /* Tidak bisa ditutup dengan klik luar */ },
                title = {
                    Text(
                        text = "Pendaftaran Berhasil!",
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF9C27B0)
                    )
                },
                text = {
                    Text(
                        text = """
                            Nama: $namaLengkap
                            Jenis Kelamin: $jenisKelamin
                            Status: $statusPerkawinan
                            Alamat: $alamat
                        """.trimIndent(),
                        fontSize = 16.sp
                    )
                },
                confirmButton = {
                    TextButton(onClick = { showPopup = false }) {
                        Text("OK", color = Color(0xFF9C27B0))
                    }
                },
                containerColor = Color.White,
                shape = RoundedCornerShape(16.dp)
            )
        }
    }
}
