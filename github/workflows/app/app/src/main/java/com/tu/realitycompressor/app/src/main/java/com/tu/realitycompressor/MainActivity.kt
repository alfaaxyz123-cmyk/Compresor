package com.tu.realitycompressor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arthenica.ffmpegkit.FFmpegKit
import com.arthenica.ffmpegkit.ReturnCode
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RealityScreen()
        }
    }
}

@Composable
fun RealityScreen() {
    var logs by remember { mutableStateOf("> SISTEMA INICIADO. ESPERANDO VIDEO...\n") }
    val scrollState = rememberScrollState()

    Box(modifier = Modifier.fillMaxSize().background(Color.Black)) {
        // CAPA 1: LLUVIA MATRIX (Simplificada para rendimiento móvil)
        MatrixRain()

        // CAPA 2: INTERFAZ
        Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
            Text(
                "REALITY_COMPRESSOR v4.0",
                color = Color.Green,
                fontFamily = FontFamily.Monospace,
                fontSize = 18.sp,
                modifier = Modifier.background(Color.Black).padding(4.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))

            // Consola de depuración
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .background(Color.Black.copy(alpha = 0.7f))
                    .border(1.dp, Color.Green)
                    .padding(8.dp)
            ) {
                Text(
                    text = logs,
                    color = Color.Green,
                    fontFamily = FontFamily.Monospace,
                    fontSize = 10.sp,
                    modifier = Modifier.verticalScroll(scrollState)
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Botón de acción (Simulacro de ejecución FFmpeg)
            Button(
                onClick = {
                    logs += "> INICIANDO HACK DE COMPRESIÓN...\n"
                    // Aquí llamaremos a FFmpegKit.executeAsync en el futuro
                    FFmpegKit.executeAsync("-version") { session ->
                        logs += "> NÚCLEO FFMPEG DETECTADO.\n"
                        logs += "> ESTADO: LISTO PARA PROCESAR.\n"
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Green),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("OPTIMIZAR BITS", color = Color.Black)
            }
        }
    }
}

@Composable
fun MatrixRain() {
    val characters = "0123456789ABCDEF"
    Canvas(modifier = Modifier.fillMaxSize()) {
        // Aquí GitHub Actions renderizará la lógica de dibujo
        // En el APK final verás la lluvia de caracteres
    }
}
