package com.example.cursokotlin.Units.Unit26

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.* // For layout management
import androidx.compose.material3.* // Material 3 for UI components
import androidx.compose.runtime.* // For managing state
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

// Composable function for the main UI
@Composable
fun Project119(modifier: Modifier = Modifier, navController: NavHostController) {
    val bank = remember { Banco() }
    var totalDeposits by remember { mutableStateOf("") }
    var showDetails by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(text = "Bank Operations")

        Button(onClick = {
            bank.operar()
            totalDeposits = bank.getTotalDeposits()
            showDetails = true
        }) {
            Text(text = "Execute Bank Operations")
        }

        if (totalDeposits.isNotEmpty()) {
            Text(text = totalDeposits)
        }

        if (showDetails) {
            ClientDetails(client = bank.cliente1)
            ClientDetails(client = bank.cliente2)
            ClientDetails(client = bank.cliente3)
        }
    }
}

// Composable function to display individual client details
@Composable
fun ClientDetails(client: Cliente) {
    Text(text = "${client.nombre} has a balance of ${client.monto}")
}

// Data class for the client
class Cliente(var nombre: String, var monto: Float) {
    fun depositar(monto: Float) {
        this.monto += monto
    }

    fun extraer(monto: Float) {
        this.monto -= monto
    }
}

// Class for the bank which operates on multiple clients
class Banco {
    val cliente1 = Cliente("Juan", 0f)
    var cliente2 = Cliente("Ana", 0f)
    var cliente3 = Cliente("Luis", 0f)

    // Function to perform operations
    fun operar() {
        cliente1.depositar(100f)
        cliente2.depositar(150f)
        cliente3.depositar(200f)
        cliente3.extraer(150f)
    }

    // Function to return the total deposits as a string
    fun getTotalDeposits(): String {
        val total = cliente1.monto + cliente2.monto + cliente3.monto
        return "The total money in the bank is: $total"
    }
}
