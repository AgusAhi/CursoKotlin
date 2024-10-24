package com.example.cursokotlin.Units.Unit47

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

data class Fecha(val dia: Int, val mes: Int, val año: Int)

@Composable
fun Project188(modifier: Modifier = Modifier, navController: NavHostController) {
    var dia by remember { mutableStateOf("") }
    var mes by remember { mutableStateOf("") }
    var año by remember { mutableStateOf("") }
    var resultMessage by remember { mutableStateOf("") }

    val feriados = setOf(
        Fecha(1, 1, 2017),
        Fecha(25, 12, 2017)
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = "Holiday Date Checker",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Date input fields
        OutlinedTextField(
            value = dia,
            onValueChange = {
                if (it.length <= 2 && it.all { char -> char.isDigit() }) dia = it
            },
            label = { Text("Day") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = mes,
            onValueChange = {
                if (it.length <= 2 && it.all { char -> char.isDigit() }) mes = it
            },
            label = { Text("Month") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = año,
            onValueChange = {
                if (it.length <= 4 && it.all { char -> char.isDigit() }) año = it
            },
            label = { Text("Year") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        // Check button
        Button(
            onClick = {
                try {
                    val diaInt = dia.toInt()
                    val mesInt = mes.toInt()
                    val añoInt = año.toInt()

                    // Validate date
                    if (isValidDate(diaInt, mesInt, añoInt)) {
                        val fecha = Fecha(diaInt, mesInt, añoInt)
                        resultMessage = if (fecha in feriados) {
                            "The entered date is a holiday!"
                        } else {
                            "The entered date is not a holiday."
                        }
                    } else {
                        resultMessage = "Please enter a valid date."
                    }
                } catch (e: NumberFormatException) {
                    resultMessage = "Please fill in all fields with valid numbers."
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            enabled = dia.isNotEmpty() && mes.isNotEmpty() && año.isNotEmpty()
        ) {
            Text("Check if it's a Holiday")
        }

        // Result message
        if (resultMessage.isNotEmpty()) {
            Text(
                text = resultMessage,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(top = 8.dp)
            )
        }

        // Display current holidays
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "Current Holidays:",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                feriados.forEach { fecha ->
                    Text("${fecha.dia}/${fecha.mes}/${fecha.año}")
                }
            }
        }
    }
}

private fun isValidDate(day: Int, month: Int, year: Int): Boolean {
    if (month < 1 || month > 12) return false
    if (day < 1) return false

    val daysInMonth = when (month) {
        2 -> if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) 29 else 28
        4, 6, 9, 11 -> 30
        else -> 31
    }

    return day <= daysInMonth && year > 0
}