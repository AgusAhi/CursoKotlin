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

class Exercise77 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Project77(modifier = Modifier, navController = rememberNavController())
        }
    }
}

@Composable
fun Project77(modifier: Modifier = Modifier, navController: NavHostController) {
    var clave1 by remember { mutableStateOf("") } // Input for first key
    var clave2 by remember { mutableStateOf("") } // Input for second key
    var resultado by remember { mutableStateOf<String?>(null) } // Store result

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Input for the first key
        OutlinedTextField(
            value = clave1,
            onValueChange = { clave1 = it },
            label = { Text("Ingrese primer clave") },
            modifier = Modifier.fillMaxWidth()
        )

        // Input for the second key
        OutlinedTextField(
            value = clave2,
            onValueChange = { clave2 = it },
            label = { Text("Repita el ingreso de la misma clave") },
            modifier = Modifier.fillMaxWidth()
        )

        // Button to verify keys
        Button(
            onClick = {
                resultado = verificarClaves(clave1, clave2)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Verificar Claves")
        }

        // Display the result
        resultado?.let { Text(it) }
    }
}

// Function to verify if both keys are the same
fun verificarClaves(clave1: String, clave2: String): String {
    return if (clave1 == clave2) {
        "Se ingresaron las dos veces la misma clave"
    } else {
        "No se ingresó las dos veces con el mismo valor"
    }
}
