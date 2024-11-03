package com.example.cursokotlin.Units.Unit48

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.cursokotlin.Units.Unit48.entradateclado.ComposableInput

@Composable
fun Project191(modifier: Modifier = Modifier, navController: NavHostController) {
    var firstNumber by remember { mutableStateOf("") }
    var secondNumber by remember { mutableStateOf("") }
    var selectedType by remember { mutableStateOf(NumberType.INTEGER) }
    var result by remember { mutableStateOf<String?>(null) }
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

        // Number type selector
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            NumberType.values().forEach { type ->
                FilterChip(
                    selected = selectedType == type,
                    onClick = {
                        selectedType = type
                        result = null
                        errorMessage = null
                    },
                    label = { Text(type.name.lowercase().capitalize()) }
                )
            }
        }

        // First number input
        OutlinedTextField(
            value = firstNumber,
            onValueChange = {
                firstNumber = it
                errorMessage = null
                result = null
            },
            label = { Text("Enter the first value:") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
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
            label = { Text("Enter the second value:") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
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
                    selectedType,
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
                        text = "The sum is $it",
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
                    text = "Input Format Examples:",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text("• Integer: 42")
                Text("• Double: 42.5")
                Text("• Float: 42.5f")
            }
        }
    }
}

enum class NumberType {
    INTEGER,
    DOUBLE,
    FLOAT
}

private fun calculateSum(
    inputHandler: ComposableInput,
    firstNumber: String,
    secondNumber: String,
    type: NumberType,
    onResult: (String) -> Unit,
    onError: (String) -> Unit
) {
    when (type) {
        NumberType.INTEGER -> {
            val num1 = inputHandler.returnInt(firstNumber)
            val num2 = inputHandler.returnInt(secondNumber)
            when {
                num1 == null -> onError("Please enter a valid first integer")
                num2 == null -> onError("Please enter a valid second integer")
                else -> onResult((num1 + num2).toString())
            }
        }
        NumberType.DOUBLE -> {
            val num1 = inputHandler.returnDouble(firstNumber)
            val num2 = inputHandler.returnDouble(secondNumber)
            when {
                num1 == null -> onError("Please enter a valid first decimal number")
                num2 == null -> onError("Please enter a valid second decimal number")
                else -> onResult(String.format("%.2f", num1 + num2))
            }
        }
        NumberType.FLOAT -> {
            val num1 = inputHandler.returnFloat(firstNumber)
            val num2 = inputHandler.returnFloat(secondNumber)
            when {
                num1 == null -> onError("Please enter a valid first decimal number")
                num2 == null -> onError("Please enter a valid second decimal number")
                else -> onResult(String.format("%.2f", num1 + num2))
            }
        }
    }
}