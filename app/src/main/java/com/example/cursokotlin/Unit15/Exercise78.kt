package com.example.cursokotlin.Unit15

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

class Proyecto78 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Project78(modifier = Modifier, navController = rememberNavController())
        }
    }
}

@Composable
fun Project78(modifier: Modifier = Modifier, navController: NavHostController) {
    var valor1 by remember { mutableStateOf("") } // Input for first value
    var valor2 by remember { mutableStateOf("") } // Input for second value
    var valor3 by remember { mutableStateOf("") } // Input for third value
    var resultado by remember { mutableStateOf<String?>(null) } // Store result

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Input for the first value
        OutlinedTextField(
            value = valor1,
            onValueChange = { valor1 = it },
            label = { Text("Ingrese primer valor") },
            modifier = Modifier.fillMaxWidth()
        )

        // Input for the second value
        OutlinedTextField(
            value = valor2,
            onValueChange = { valor2 = it },
            label = { Text("Ingrese segundo valor") },
            modifier = Modifier.fillMaxWidth()
        )

        // Input for the third value
        OutlinedTextField(
            value = valor3,
            onValueChange = { valor3 = it },
            label = { Text("Ingrese tercer valor") },
            modifier = Modifier.fillMaxWidth()
        )

        // Button to order values
        Button(
            onClick = {
                resultado = ordenarMayorMenor(valor1.toInt(), valor2.toInt(), valor3.toInt())
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Ordenar")
        }

        // Display the result
        resultado?.let { Text("Ordenado: $it") }
    }
}

// Function to order values from greater to lesser
fun ordenarMayorMenor(valor1: Int, valor2: Int, valor3: Int): String {
    return when {
        valor1 >= valor2 && valor1 >= valor3 -> {
            if (valor2 >= valor3) "$valor1 $valor2 $valor3"
            else "$valor1 $valor3 $valor2"
        }
        valor2 >= valor1 && valor2 >= valor3 -> {
            if (valor1 >= valor3) "$valor2 $valor1 $valor3"
            else "$valor2 $valor3 $valor1"
        }
        else -> {
            if (valor1 >= valor2) "$valor3 $valor1 $valor2"
            else "$valor3 $valor2 $valor1"
        }
    }
}
