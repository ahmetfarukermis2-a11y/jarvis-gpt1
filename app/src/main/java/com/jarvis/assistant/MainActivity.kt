
package com.jarvis.assistant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JarvisScreen()
        }
    }
}

@Composable
fun JarvisScreen() {
    var command by remember { mutableStateOf("") }
    var response by remember {
        mutableStateOf("Sistem hazır. Komutunu bekliyorum.")
    }

    val background = Brush.verticalGradient(
        listOf(Color(0xFF07111F), Color(0xFF02050B))
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(background)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            "J.A.R.V.I.S",
            color = Color(0xFF55DFFF),
            fontSize = 30.sp
        )

        Spacer(Modifier.height(36.dp))

        Box(
            modifier = Modifier
                .size(190.dp)
                .background(
                    Brush.radialGradient(
                        listOf(
                            Color(0xFF55DFFF),
                            Color(0xFF123B65),
                            Color(0xFF07111F)
                        )
                    ),
                    CircleShape
                ),
            contentAlignment = Alignment.Center
        ) {
            Text("J", color = Color.White, fontSize = 76.sp)
        }

        Spacer(Modifier.height(28.dp))

        Text(
            response,
            color = Color.White,
            fontSize = 16.sp
        )

        Spacer(Modifier.height(24.dp))

        OutlinedTextField(
            value = command,
            onValueChange = { command = it },
            label = { Text("Komutunu yaz") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(12.dp))

        Button(
            onClick = {
                response = when {
                    command.isBlank() ->
                        "Efendim, bir komut girmen gerekiyor."

                    command.contains("merhaba", true) ->
                        "Merhaba efendim. Sistem hazır."

                    command.contains("saat", true) ->
                        "Saati telefonunuzdan kontrol edebilirsiniz."

                    else ->
                        "Komut alındı: $command. Bu sürümde AI bağlantısı henüz yok."
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("KOMUTU ÇALIŞTIR")
        }
    }
}
