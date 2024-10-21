package com.example.cursokotlin.Units.Unit32

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

// Base class Dado
open class Dado {
    protected var valor: Int = 1

    fun tirar() {
        valor = ((Math.random() * 6) + 1).toInt()
    }

    open fun imprimir(): String {
        return valor.toString()
    }
}

// Derived class DadoRecuadro with overridden imprimir method
class DadoRecuadro : Dado() {
    override fun imprimir(): String {
        return """
            ***
            *$valor*
            ***
        """.trimIndent()
    }
}

// Jetpack Compose function
@Composable
fun Project139(navController: NavHostController, modifier: Modifier = Modifier) {
    var dadoOutput by remember { mutableStateOf("") }
    var dadoRecuadroOutput by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        // Button to trigger the dice throw for the Dado class
        Button(onClick = {
            val dado1 = Dado()
            dado1.tirar()
            dadoOutput = "Dado Result: ${dado1.imprimir()}"
        }) {
            Text(text = "Throw Dado", fontSize = 18.sp)
        }
        Text(text = dadoOutput, fontSize = 16.sp, modifier = Modifier.padding(top = 8.dp))

        // Button to trigger the dice throw for the DadoRecuadro class
        Button(onClick = {
            val dado2 = DadoRecuadro()
            dado2.tirar()
            dadoRecuadroOutput = "DadoRecuadro Result:\n${dado2.imprimir()}"
        }, modifier = Modifier.padding(top = 16.dp)) {
            Text(text = "Throw Dado with Box", fontSize = 18.sp)
        }
        Text(text = dadoRecuadroOutput, fontSize = 16.sp, modifier = Modifier.padding(top = 8.dp))
    }
}
