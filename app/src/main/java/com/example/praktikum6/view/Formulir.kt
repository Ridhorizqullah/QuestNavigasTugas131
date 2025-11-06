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

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF3E5F5)) // Ungu muda
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(Color(0xFFCE93D8)) // Ungu header
                .padding(horizontal = 24.dp),
            contentAlignment = Alignment.CenterStart
        ){
            Row(
                verticalAlignment = Alignment.CenterVertically
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

    }