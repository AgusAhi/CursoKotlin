package com.example.cursokotlin.Units.Unit32

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import kotlin.math.sqrt

open class Persona(val nombre: String, val edad: Int) {
    open fun imprimir(): String {
        return "Name: $nombre\nAge: $edad"
    }
}

class Empleado(nombre: String, edad: Int, val sueldo: Double) : Persona(nombre, edad) {
    override fun imprimir(): String {
        return super.imprimir() + "\nSalary: $sueldo"
    }

    fun pagaImpuestos(): String {
        return if (sueldo > 3000) "Employee $nombre pays taxes" else "Employee $nombre does not pay taxes"
    }
}

open class Calculadora(val valor1: Double, val valor2: Double) {
    var resultado: Double = 0.0

    fun sumar() {
        resultado = valor1 + valor2
    }

    fun restar() {
        resultado = valor1 - valor2
    }

    fun multiplicar() {
        resultado = valor1 * valor2
    }

    fun dividir() {
        resultado = valor1 / valor2
    }

    fun imprimir(): String {
        return "Result: $resultado"
    }
}

class CalculadoraCientifica(valor1: Double, valor2: Double) : Calculadora(valor1, valor2) {
    fun cuadrado() {
        resultado = valor1 * valor1
    }

    fun raiz() {
        resultado = sqrt(valor1)
    }
}

@Composable
fun Project138(navController: NavHostController, modifier: Modifier = Modifier) {
    var personaOutput by remember { mutableStateOf("") }
    var empleadoOutput by remember { mutableStateOf("") }
    var calculadoraOutput by remember { mutableStateOf("") }
    var calculadoraCientificaOutput by remember { mutableStateOf("") }

    Column(modifier = modifier.fillMaxSize()) {
        // Button to trigger Persona details
        Button(onClick = {
            val persona1 = Persona("Jose", 22)
            personaOutput = "Person Data:\n${persona1.imprimir()}"
        }) {
            Text(text = "Show Person Info", fontSize = 20.sp)
        }
        Text(text = personaOutput, fontSize = 16.sp)

        // Button to trigger Empleado details
        Button(onClick = {
            val empleado1 = Empleado("Ana", 30, 5000.0)
            empleadoOutput = "Employee Data:\n${empleado1.imprimir()}\n${empleado1.pagaImpuestos()}"
        }) {
            Text(text = "Show Employee Info", fontSize = 20.sp)
        }
        Text(text = empleadoOutput, fontSize = 16.sp)

        // Button to trigger Calculadora operations
        Button(onClick = {
            val calculadora1 = Calculadora(10.0, 2.0)
            calculadora1.sumar()
            calculadoraOutput = "Calculator (sum of two numbers):\n${calculadora1.imprimir()}"
        }) {
            Text(text = "Show Calculator Info", fontSize = 20.sp)
        }
        Text(text = calculadoraOutput, fontSize = 16.sp)

        // Button to trigger Calculadora Científica operations
        Button(onClick = {
            val calculadoraCientifica1 = CalculadoraCientifica(10.0, 2.0)
            calculadoraCientifica1.sumar()
            calculadoraCientifica1.cuadrado()
            calculadoraCientifica1.raiz()
            calculadoraCientificaOutput = """
                Scientific Calculator:
                Sum: ${calculadoraCientifica1.imprimir()}
                Square: ${calculadoraCientifica1.imprimir()}
                Square root: ${calculadoraCientifica1.imprimir()}
            """.trimIndent()
        }) {
            Text(text = "Show Scientific Calculator Info", fontSize = 20.sp)
        }
        Text(text = calculadoraCientificaOutput, fontSize = 16.sp)
    }
}

