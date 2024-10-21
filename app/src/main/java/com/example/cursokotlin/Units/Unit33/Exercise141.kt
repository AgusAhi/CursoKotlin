package com.example.cursokotlin.Units.Unit33

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

// Abstract class Cuenta
abstract class Cuenta(val titular: String, val monto: Double) {
    open fun imprimir(): String {
        return "Holder: $titular\nAmount: $monto"
    }
}

// Class CajaAhorro (Savings Account)
class CajaAhorro(titular: String, monto: Double) : Cuenta(titular, monto) {
    override fun imprimir(): String {
        return "Savings Account\n${super.imprimir()}"
    }
}

// Class PlazoFijo (Fixed-term Deposit Account)
class PlazoFijo(titular: String, monto: Double, val plazo: Int, val interes: Double) : Cuenta(titular, monto) {
    override fun imprimir(): String {
        val ganancia = monto * interes / 100
        return """
            Fixed-term Account
            Term in days: $plazo
            Interest rate: $interes%
            Interest amount: $ganancia
            ${super.imprimir()}
        """.trimIndent()
    }
}

// Jetpack Compose function
@Composable
fun Project141(navController: NavHostController, modifier: Modifier = Modifier) {
    var cajaAhorroOutput by remember { mutableStateOf("") }
    var plazoFijoOutput by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        // Button to display CajaAhorro (Savings Account) details
        Button(onClick = {
            val cajaAhorro1 = CajaAhorro("Juan", 10000.0)
            cajaAhorroOutput = cajaAhorro1.imprimir()
        }) {
            Text(text = "Show Savings Account Info", fontSize = 18.sp)
        }
        Text(text = cajaAhorroOutput, fontSize = 16.sp, modifier = Modifier.padding(top = 8.dp))

        // Button to display PlazoFijo (Fixed-term Deposit) details
        Button(onClick = {
            val plazoFijo1 = PlazoFijo("Ana", 5000.0, 30, 1.23)
            plazoFijoOutput = plazoFijo1.imprimir()
        }, modifier = Modifier.padding(top = 16.dp)) {
            Text(text = "Show Fixed-term Deposit Info", fontSize = 18.sp)
        }
        Text(text = plazoFijoOutput, fontSize = 16.sp, modifier = Modifier.padding(top = 8.dp))
    }
}

