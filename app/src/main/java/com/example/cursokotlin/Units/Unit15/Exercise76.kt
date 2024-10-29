package com.example.cursokotlin.Units.Unit15

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun Project76(modifier: Modifier = Modifier, navController: NavHostController) {
    var side by remember { mutableStateOf("") }
    var result by remember { mutableStateOf<String?>(null) }
    var selection by remember { mutableStateOf("") }
    var error by remember { mutableStateOf<String?>(null) }
    val focusManager = LocalFocusManager.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Input for the side length
        OutlinedTextField(
            value = side,
            onValueChange = {
                if (it.isEmpty() || it.matches(Regex("^\\d*\$"))) {
                    side = it
                    error = null
                }
            },
            label = { Text("Enter the value of the side of a square") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            isError = error != null,
            supportingText = { error?.let { Text(it) } }
        )

        // Radio buttons for selection
        Column {
            Text("Select calculation type:", modifier = Modifier.padding(bottom = 8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                RadioButton(
                    selected = selection == "perimeter",
                    onClick = { selection = "perimeter" }
                )
                Text("Perimeter")

                RadioButton(
                    selected = selection == "area",
                    onClick = { selection = "area" }
                )
                Text("Area")
            }
        }

        // Button to calculate
        Button(
            onClick = {
                focusManager.clearFocus()
                when {
                    side.isEmpty() -> {
                        error = "Please enter a side length"
                        result = null
                    }
                    selection.isEmpty() -> {
                        error = "Please select perimeter or area"
                        result = null
                    }
                    else -> {
                        val sideInt = side.toIntOrNull() ?: 0
                        if (sideInt <= 0) {
                            error = "Side length must be greater than 0"
                            result = null
                        } else {
                            error = null
                            result = when (selection) {
                                "perimeter" -> "The perimeter is ${calculatePerimeter(sideInt)} units"
                                "area" -> "The area is ${calculateArea(sideInt)} square units"
                                else -> "Invalid option"
                            }
                        }
                    }
                }
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = side.isNotEmpty() && selection.isNotEmpty()
        ) {
            Text("Calculate")
        }

        // Display the result
        result?.let {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Text(
                    text = it,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}

private fun calculatePerimeter(side: Int): Int {
    return side * 4
}

private fun calculateArea(side: Int): Int {
    return side * side
}

fun mainConsole() {
    println("Enter the value of the side of a square: ")
    val sideInput = readLine()

    val side = sideInput?.toIntOrNull()
    if (side == null || side <= 0) {
        println("Invalid input. Please enter a positive number.")
        return
    }

    println("Would you like to calculate the perimeter or the area? [Enter text: perimeter/area]")
    when (readLine()?.lowercase()) {
        "perimeter" -> println("The perimeter is ${calculatePerimeter(side)} units")
        "area" -> println("The area is ${calculateArea(side)} square units")
        else -> println("Invalid option. Please enter either 'perimeter' or 'area'.")
    }
}
