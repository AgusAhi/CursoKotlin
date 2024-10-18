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
import kotlin.random.Random

// Composable function for the main UI
@Composable
fun Project120(modifier: Modifier = Modifier, navController: NavHostController) {
    val juegoDeDados = remember { JuegoDeDados() }
    var resultado by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
    ) {
        Text(text = "Dice Game", style = MaterialTheme.typography.titleLarge)

        Button(onClick = {
            resultado = juegoDeDados.jugar()
        }) {
            Text(text = "Roll the Dice")
        }

        if (resultado.isNotEmpty()) {
            Text(text = resultado)
        }

        Text(text = "Die 1: ${juegoDeDados.dado1.valor}")
        Text(text = "Die 2: ${juegoDeDados.dado2.valor}")
        Text(text = "Die 3: ${juegoDeDados.dado3.valor}")
    }
}

// Dice class
class Dado(var valor: Int) {
    // Function to simulate rolling the dice
    fun tirar() {
        valor = Random.nextInt(1, 7)  // Generates a random number between 1 and 6
    }
}

// Class for the dice game logic
class JuegoDeDados {
    val dado1 = Dado(1)
    val dado2 = Dado(1)
    val dado3 = Dado(1)

    // Function to simulate the game and return the result
    fun jugar(): String {
        dado1.tirar()
        dado2.tirar()
        dado3.tirar()

        return if (dado1.valor == dado2.valor && dado2.valor == dado3.valor) {
            "You Won! All dice show ${dado1.valor}."
        } else {
            "You Lost. Dice show ${dado1.valor}, ${dado2.valor}, and ${dado3.valor}."
        }
    }
}
