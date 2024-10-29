package com.example.cursokotlin.Units.Unit26

import androidx.compose.foundation.layout.* // For layout management
import androidx.compose.material3.* // Material 3 for UI components
import androidx.compose.runtime.* // For managing state
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

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
            bank.operate()
            totalDeposits = bank.getTotalDeposits()
            showDetails = true
        }) {
            Text(text = "Execute Bank Operations")
        }

        if (totalDeposits.isNotEmpty()) {
            Text(text = totalDeposits)
        }

        if (showDetails) {
            ClientDetails(client = bank.client1)
            ClientDetails(client = bank.client2)
            ClientDetails(client = bank.client3)
        }
    }
}

// Composable function to display individual client details
@Composable
fun ClientDetails(client: Client) {
    Text(text = "${client.nombre} has a balance of ${client.monto}")
}

// Data class for the client
class Client(var nombre: String, var monto: Float) {
    fun deposit(monto: Float) {
        this.monto += monto
    }

    fun extract(monto: Float) {
        this.monto -= monto
    }
}

// Class for the bank which operates on multiple clients
class Banco {
    val client1 = Client("Juan", 0f)
    var client2 = Client("Ana", 0f)
    var client3 = Client("Luis", 0f)

    // Function to perform operations
    fun operate() {
        client1.deposit(100f)
        client2.deposit(150f)
        client3.deposit(200f)
        client3.extract(150f)
    }

    // Function to return the total deposits as a string
    fun getTotalDeposits(): String {
        val total = client1.monto + client2.monto + client3.monto
        return "The total money in the bank is: $total"
    }
}
