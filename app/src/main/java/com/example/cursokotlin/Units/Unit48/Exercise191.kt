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
import com.example.cursokotlin.Units.Unit47.entradateclado.ComposableInput

@Composable
fun Project191(modifier: Modifier = Modifier, navController: NavHostController) {
    var firstNumber by remember { mutableStateOf("") }
    var secondNumber by remember { mutableStateOf("") }
    var result by remember { mutableStateOf<Int?>(null) }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    val inputHandler = remember { ComposableInput() }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Number Input and Addition",
            style = MaterialTheme.typography.headlineMedium
        )

        // First number input
        OutlinedTextField(
            value = firstNumber,
            onValueChange = {
                firstNumber = it
                errorMessage = null
                result = null
            },
            label = { Text("Ingrese primer valor:") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            isError = errorMessage != null && firstNumber.isEmpty(),
            modifier = Modifier.fillMaxWidth()
        )

        // Second number input
        OutlinedTextField(
            value = secondNumber,
            onValueChange = {
                secondNumber = it
                errorMessage = null
                result = null
            },
            label = { Text("Ingrese segundo valor:") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            isError = errorMessage != null && secondNumber.isEmpty(),
            modifier = Modifier.fillMaxWidth()
        )

        // Calculate button
        Button(
            onClick = {
                calculateSum(
                    inputHandler,
                    firstNumber,
                    secondNumber,
                    onResult = { newResult ->
                        result = newResult
                    },
                    onError = { message ->
                        errorMessage = message
                    }
                )
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Calculate Sum")
        }

        // Result display
        result?.let {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Result",
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        text = "La suma es $it",
                        style = MaterialTheme.typography.headlineSmall,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }

        // Error message
        errorMessage?.let {
            Text(
                text = it,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodyMedium
            )
        }

        // Example usage section
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "Available Input Types:",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text("• Integer (whole numbers)")
                Text("• Double (decimal numbers)")
                Text("• Float (decimal numbers)")

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Try entering different number types!",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.secondary
                )
            }
        }
    }
}

private fun calculateSum(
    inputHandler: ComposableInput,
    firstNumber: String,
    secondNumber: String,
    onResult: (Int) -> Unit,
    onError: (String) -> Unit
) {
    val num1 = inputHandler.retornarInt(firstNumber)
    val num2 = inputHandler.retornarInt(secondNumber)

    when {
        num1 == null -> onError("Please enter a valid first number")
        num2 == null -> onError("Please enter a valid second number")
        else -> onResult(num1 + num2)
    }
}