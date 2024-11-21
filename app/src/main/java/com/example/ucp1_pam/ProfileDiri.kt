package com.example.ucp1_pam

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp


@Preview(showBackground = true)
@Composable
fun ProfileDiri(modifier: Modifier = Modifier) {
    var nama by remember { mutableStateOf("") }
    var noHp by remember { mutableStateOf("") }
    var jenisK by remember { mutableStateOf("") }

    var dataNama by remember { mutableStateOf("") }
    var dataNoHp by remember { mutableStateOf("") }
    var dataJenisK by remember { mutableStateOf("") }
    val dataJK = listOf("Laki-laki", "Perempuan")

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF0092F4))
                .padding(50.dp)

        ) {
            Icon(Icons.Default.Menu,
                contentDescription = null,
                modifier = Modifier .size(28.dp),
                tint = Color.White,

            )
            Spacer(modifier = Modifier.padding(10.dp))
            Text(
                text = "Halo,",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Text(
                text = nama,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                color = Color.White
            )

            Row {
                Box(
                    contentAlignment = Alignment.TopEnd
                ) {

                }
            }
        }

        Column (modifier = modifier
            .fillMaxSize().padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "Yuk Lengkapi data dirimu!", fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.padding(20.dp))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth().padding(5.dp),
                value = nama,
                onValueChange = { nama = it },
                label = { Text("Nama") },
                placeholder = {
                    Text("Masukkan Nama Anda")
                }
            )

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth().padding(5.dp),
                value = noHp,
                onValueChange = { noHp = it },
                label = { Text("No Handphone") },
                placeholder = {
                    Text("Masukkan No HP anda")
                }
            )

            Row(modifier = Modifier) {
                Text(text = "Jenis Kelamin")
                dataJK.forEach { selectedJK ->
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(selected = jenisK == selectedJK,
                            onClick = {
                                jenisK = selectedJK
                            }
                        )
                        Text(selectedJK)
                    }
                }
            }

            Button(onClick = {
                dataNama = nama
                dataJenisK = jenisK
                dataNoHp = noHp
            }, modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp)

            )
            {
                Text("Simpan")

            }

            Card(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
                Column {

                    TampilData(
                        judul = "No HP",
                        isi = dataNoHp
                    )
                    TampilData(
                        judul = "Jenis Kelamin",
                        isi = dataJenisK
                    )
                }
            }
        }
    }
}

@Composable
fun TampilData(
    judul : String,
    isi : String
) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween) {
        Text(judul, modifier = Modifier.weight(2f))
        Text(isi, modifier = Modifier.weight(2f))
    }

}
