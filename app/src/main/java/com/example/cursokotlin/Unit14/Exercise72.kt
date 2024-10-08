package com.example.cursokotlin.Unit14

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

class Exercise72 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Project72(modifier = Modifier, navController = rememberNavController())
        }
    }
}

@Composable
fun Project72(modifier: Modifier = Modifier, navController: NavHostController) {
    var inputValue by remember { mutableStateOf("") } // Input for the integer value
    var inputValue1 by remember { mutableStateOf("") } // Input for the first value
    var inputValue2 by remember { mutableStateOf("") } // Input for the second value
    var squareResult by remember { mutableStateOf<String?>(null) } // Store square result
    var productResult by remember { mutableStateOf<String?>(null) } // Store product result

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Input for the integer value to calculate the square
        OutlinedTextField(
            value = inputValue,
            onValueChange = { inputValue = it },
            label = { Text("Enter an integer to calculate its square") },
            modifier = Modifier.fillMaxWidth()
        )

        // Button to calculate the square
        Button(
            onClick = {
                val value = inputValue.toIntOrNull() ?: 0 // Convert input to int
                squareResult = (value * value).toString() // Calculate square
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Calculate Square")
        }

        // Display the result of the square calculation
        if (squareResult != null) {
            Text("The square is: $squareResult")
        }

        // Input for the first value
        OutlinedTextField(
            value = inputValue1,
            onValueChange = { inputValue1 = it },
            label = { Text("Enter the first value") },
            modifier = Modifier.fillMaxWidth()
        )

        // Input for the second value
        OutlinedTextField(
            value = inputValue2,
            onValueChange = { inputValue2 = it },
            label = { Text("Enter the second value") },
            modifier = Modifier.fillMaxWidth()
        )

        // Button to calculate the product
        Button(
            onClick = {
                val value1 = inputValue1.toIntOrNull() ?: 0 // Convert first input to int
                val value2 = inputValue2.toIntOrNull() ?: 0 // Convert second input to int
                productResult = (value1 * value2).toString() // Calculate product
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Calculate Product")
        }

        // Display the result of the product calculation
        if (productResult != null) {
            Text("The product of the values is: $productResult")
        }
    }
}
