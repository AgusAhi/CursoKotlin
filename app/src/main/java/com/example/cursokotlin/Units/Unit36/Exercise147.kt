package com.example.cursokotlin.Units.Unit36

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

fun operate(v1: Int, v2: Int, fn: (Int, Int) -> Int): Int {
    return fn(v1, v2)
}

fun add(x1: Int, x2: Int) = x1 + x2
fun subtract(x1: Int, x2: Int) = x1 - x2
fun multiply(x1: Int, x2: Int) = x1 * x2
fun divide(x1: Int, x2: Int) = if (x2 != 0) x1 / x2 else 0

@Composable
fun OperationButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier.width(80.dp)
    ) {
        Text(text)
    }
}

@Composable
fun Project147(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    var firstNumber by remember { mutableStateOf("") }
    var secondNumber by remember { mutableStateOf("") }
    var result by remember { mutableStateOf<Int?>(null) }
    var lastOperation by remember { mutableStateOf("") }
    var error by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Calculator",
            style = MaterialTheme.typography.headlineMedium,
            textAlign = TextAlign.Center
        )

        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                OutlinedTextField(
                    value = firstNumber,
                    onValueChange = {
                        firstNumber = it.filter { char -> char.isDigit() }
                        error = ""
                    },
                    label = { Text("First Number") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.fillMaxWidth()
                )

                OutlinedTextField(
                    value = secondNumber,
                    onValueChange = {
                        secondNumber = it.filter { char -> char.isDigit() }
                        error = ""
                    },
                    label = { Text("Second Number") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.fillMaxWidth()
                )

                if (error.isNotEmpty()) {
                    Text(
                        text = error,
                        color = MaterialTheme.colorScheme.error,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    OperationButton(
                        text = "+",
                        onClick = {
                            performOperation(
                                firstNumber,
                                secondNumber,
                                ::add,
                                "Addition"
                            ) { r, e ->
                                result = r
                                error = e
                                if (e.isEmpty()) lastOperation = "Addition"
                            }
                        }
                    )

                    OperationButton(
                        text = "-",
                        onClick = {
                            performOperation(
                                firstNumber,
                                secondNumber,
                                ::subtract,
                                "Subtraction"
                            ) { r, e ->
                                result = r
                                error = e
                                if (e.isEmpty()) lastOperation = "Subtraction"
                            }
                        }
                    )

                    OperationButton(
                        text = "×",
                        onClick = {
                            performOperation(
                                firstNumber,
                                secondNumber,
                                ::multiply,
                                "Multiplication"
                            ) { r, e ->
                                result = r
                                error = e
                                if (e.isEmpty()) lastOperation = "Multiplication"
                            }
                        }
                    )

                    OperationButton(
                        text = "÷",
                        onClick = {
                            performOperation(
                                firstNumber,
                                secondNumber,
                                ::divide,
                                "Division"
                            ) { r, e ->
                                result = r
                                error = e
                                if (e.isEmpty()) lastOperation = "Division"
                            }
                        }
                    )
                }
            }
        }

        if (result != null && error.isEmpty()) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.secondaryContainer
                )
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = lastOperation,
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        text = "Result: $result",
                        style = MaterialTheme.typography.headlineMedium
                    )
                }
            }
        }
    }
}

private fun performOperation(
    firstNumber: String,
    secondNumber: String,
    operation: (Int, Int) -> Int,
    operationName: String,
    callback: (Int?, String) -> Unit
) {
    if (firstNumber.isEmpty() || secondNumber.isEmpty()) {
        callback(null, "Please enter both numbers")
        return
    }

    try {
        val num1 = firstNumber.toInt()
        val num2 = secondNumber.toInt()

        if (operationName == "Division" && num2 == 0) {
            callback(null, "Cannot divide by zero")
            return
        }

        val result = operate(num1, num2, operation)
        callback(result, "")
    } catch (e: NumberFormatException) {
        callback(null, "Invalid number format")
    } catch (e: Exception) {
        callback(null, "An error occurred")
    }
}