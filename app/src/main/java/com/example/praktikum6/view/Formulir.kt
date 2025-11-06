package com.example.praktikum6.view

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.automirrored.filled.ArrowBack
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
    onBack: () -> Unit
) {
    val context = LocalContext.current

    var namaLengkap by remember { mutableStateOf("") }
    var jenisKelamin by remember { mutableStateOf("") }
    var statusPerkawinan by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }

    var namaError by remember { mutableStateOf(false) }
    var alamatError by remember { mutableStateOf(false) }

    val jenisKelaminOptions = listOf("Laki-laki", "Perempuan")
    val statusPerkawinanOptions = listOf("Janda", "Lajang", "Duda")

    // Tidak perlu Scaffold jika ingin background full — pakai Column root
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF3E5F5)) // Ungu muda
    ) {
        // Header
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(Color(0xFFCE93D8)) // Ungu header
                .padding(horizontal = 24.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = onBack,
                    modifier = Modifier.size(40.dp)
                ) {
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

        // Card Form
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
                // Nama Lengkap
                Column(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = stringResource(R.string.label_nama),
                        fontSize = 12.sp,
                        color = Color.Gray,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    OutlinedTextField(
                        value = namaLengkap,
                        onValueChange = {
                            namaLengkap = it
                            namaError = false
                        },
                        placeholder = { Text(stringResource(R.string.hint_nama)) },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(8.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            unfocusedBorderColor = Color(0xFFB39DDB),
                            focusedBorderColor = Color(0xFF9C27B0)
                        ),
                        isError = namaError,
                        singleLine = true
                    )
                    if (namaError) {
                        Text(
                            text = "Nama lengkap harus diisi",
                            color = Color.Red,
                            fontSize = 12.sp,
                            modifier = Modifier.padding(start = 8.dp, top = 4.dp)
                        )
                    }
                }

                // Jenis Kelamin
                Column(modifier = Modifier.fillMaxWidth()) {
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
                                onClick = null, // handled by Row
                                colors = RadioButtonDefaults.colors(selectedColor = Color(0xFF9C27B0))
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(text = option, fontSize = 16.sp)
                        }
                    }
                }

                // Status Perkawinan
                Column(modifier = Modifier.fillMaxWidth()) {
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
                                onClick = null,
                                colors = RadioButtonDefaults.colors(selectedColor = Color(0xFF9C27B0))
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(text = option, fontSize = 16.sp)
                        }
                    }
                }

                // Alamat
                Column(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = "ALAMAT",
                        fontSize = 12.sp,
                        color = Color.Gray,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    OutlinedTextField(
                        value = alamat,
                        onValueChange = {
                            alamat = it
                            alamatError = false
                        },
                        placeholder = { Text("Alamat") },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(8.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            unfocusedBorderColor = Color(0xFFB39DDB),
                            focusedBorderColor = Color(0xFF9C27B0)
                        ),
                        isError = alamatError,
                        singleLine = true
                    )
                    if (alamatError) {
                        Text(
                            text = "Alamat harus diisi",
                            color = Color.Red,
                            fontSize = 12.sp,
                            modifier = Modifier.padding(start = 8.dp, top = 4.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Tombol Submit
                Button(
                    onClick = {
                        namaError = namaLengkap.isEmpty()
                        alamatError = alamat.isEmpty()

                        if (namaLengkap.isEmpty()) {
                            Toast.makeText(context, "Nama lengkap harus diisi", Toast.LENGTH_SHORT).show()
                            return@Button
                        }
                        if (jenisKelamin.isEmpty()) {
                            Toast.makeText(context, "Pilih jenis kelamin", Toast.LENGTH_SHORT).show()
                            return@Button
                        }
                        if (statusPerkawinan.isEmpty()) {
                            Toast.makeText(context, "Pilih status perkawinan", Toast.LENGTH_SHORT).show()
                            return@Button
                        }
                        if (alamat.isEmpty()) {
                            Toast.makeText(context, "Alamat harus diisi", Toast.LENGTH_SHORT).show()
                            return@Button
                        }

                        Toast.makeText(context, "Pendaftaran berhasil!", Toast.LENGTH_LONG).show()
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp),
                    shape = RoundedCornerShape(24.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF9C27B0))
                ) {
                    Text("Submit", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.White)
                }
            }
        }
    }
}