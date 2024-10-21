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

// Abstract class Operacion
abstract class Operacion(val valor1: Int, val valor2: Int) {
    protected var resultado: Int = 0
    abstract fun operar()
    fun imprimir(): String {
        return "Result: $resultado"
    }
}

// Class Suma (Addition)
class Suma(valor1: Int, valor2: Int) : Operacion(valor1, valor2) {
    override fun operar() {
        resultado = valor1 + valor2
    }
}

// Class Resta (Subtraction)
class Resta(valor1: Int, valor2: Int) : Operacion(valor1, valor2) {
    override fun operar() {
        resultado = valor1 - valor2
    }
}

// Jetpack Compose function
@Composable
fun Project140(navController: NavHostController, modifier: Modifier = Modifier) {
    var sumaResult by remember { mutableStateOf("") }
    var restaResult by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        // Button to trigger Suma (addition)
        Button(onClick = {
            val suma1 = Suma(10, 4)
            suma1.operar()
            sumaResult = suma1.imprimir()
        }) {
            Text(text = "Perform Addition", fontSize = 18.sp)
        }
        Text(text = sumaResult, fontSize = 16.sp, modifier = Modifier.padding(top = 8.dp))

        // Button to trigger Resta (subtraction)
        Button(onClick = {
            val resta1 = Resta(20, 5)
            resta1.operar()
            restaResult = resta1.imprimir()
        }, modifier = Modifier.padding(top = 16.dp)) {
            Text(text = "Perform Subtraction", fontSize = 18.sp)
        }
        Text(text = restaResult, fontSize = 16.sp, modifier = Modifier.padding(top = 8.dp))
    }
}

