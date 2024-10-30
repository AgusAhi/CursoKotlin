package com.example.cursokotlin.Units.Unit32

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import kotlin.math.sqrt

open class Persona(val name: String, val age: Int) {
    open fun print(): String {
        return "Name: $name\nAge: $age"
    }
}

class Empleado(name: String, age: Int, val salary: Double) : Persona(name, age) {
    override fun print(): String {
        return super.print() + "\nSalary: $salary"
    }

    fun payTaxes(): String {
        return if (salary > 3000) "Employee $name pays taxes" else "Employee $name does not pay taxes"
    }
}

open class Calculator(val valor1: Double, val valor2: Double) {
    var resultado: Double = 0.0

    fun sum() {
        resultado = valor1 + valor2
    }

    fun substract() {
        resultado = valor1 - valor2
    }

    fun multiply() {
        resultado = valor1 * valor2
    }

    fun divide() {
        resultado = valor1 / valor2
    }

    fun print(): String {
        return "Result: $resultado"
    }
}

class ScientificCalculator(valor1: Double, valor2: Double) : Calculator(valor1, valor2) {
    fun square() {
        resultado = valor1 * valor1
    }

    fun squareRoot() {
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
            personaOutput = "Person Data:\n${persona1.print()}"
        }) {
            Text(text = "Show Person Info", fontSize = 20.sp)
        }
        Text(text = personaOutput, fontSize = 16.sp)

        // Button to trigger Empleado details
        Button(onClick = {
            val empleado1 = Empleado("Ana", 30, 5000.0)
            empleadoOutput = "Employee Data:\n${empleado1.print()}\n${empleado1.payTaxes()}"
        }) {
            Text(text = "Show Employee Info", fontSize = 20.sp)
        }
        Text(text = empleadoOutput, fontSize = 16.sp)

        // Button to trigger Calculadora operations
        Button(onClick = {
            val calculator1 = Calculator(10.0, 2.0)
            calculator1.sum()
            calculadoraOutput = "Calculator (sum of two numbers):\n${calculator1.print()}"
        }) {
            Text(text = "Show Calculator Info", fontSize = 20.sp)
        }
        Text(text = calculadoraOutput, fontSize = 16.sp)

        // Button to trigger Calculadora Científica operations
        Button(onClick = {
            val calculadoraCientifica1 = ScientificCalculator(10.0, 2.0)
            calculadoraCientifica1.sum()
            calculadoraCientifica1.square()
            calculadoraCientifica1.squareRoot()
            calculadoraCientificaOutput = """
                Scientific Calculator:
                Sum: ${calculadoraCientifica1.print()}
                Square: ${calculadoraCientifica1.print()}
                Square root: ${calculadoraCientifica1.print()}
            """.trimIndent()
        }) {
            Text(text = "Show Scientific Calculator Info", fontSize = 20.sp)
        }
        Text(text = calculadoraCientificaOutput, fontSize = 16.sp)
    }
}

