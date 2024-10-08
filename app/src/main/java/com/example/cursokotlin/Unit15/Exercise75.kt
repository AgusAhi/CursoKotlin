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

class Exercise75 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Project75(modifier = Modifier, navController = rememberNavController())
        }
    }
}

@Composable
fun Project75(modifier: Modifier = Modifier, navController: NavHostController) {
    var inputValue1 by remember { mutableStateOf("") } // Input for the first value
    var inputValue2 by remember { mutableStateOf("") } // Input for the second value
    var inputValue3 by remember { mutableStateOf("") } // Input for the third value
    var result by remember { mutableStateOf<String?>(null) } // Store largest value result

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Input for the first value
        OutlinedTextField(
            value = inputValue1,
            onValueChange = { inputValue1 = it },
            label = { Text("Ingrese primer valor") },
            modifier = Modifier.fillMaxWidth()
        )

        // Input for the second value
        OutlinedTextField(
            value = inputValue2,
            onValueChange = { inputValue2 = it },
            label = { Text("Ingrese segundo valor") },
            modifier = Modifier.fillMaxWidth()
        )

        // Input for the third value
        OutlinedTextField(
            value = inputValue3,
            onValueChange = { inputValue3 = it },
            label = { Text("Ingrese tercer valor") },
            modifier = Modifier.fillMaxWidth()
        )

        // Button to show the largest value
        Button(
            onClick = {
                val value1 = inputValue1.toIntOrNull() ?: Int.MIN_VALUE // Convert first input to int
                val value2 = inputValue2.toIntOrNull() ?: Int.MIN_VALUE // Convert second input to int
                val value3 = inputValue3.toIntOrNull() ?: Int.MIN_VALUE // Convert third input to int
                result = getMax(value1, value2, value3).toString() // Calculate the largest value
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Mostrar Mayor")
        }

        // Display the result of the largest value
        if (result != null) {
            Text("Mayor: $result")
        }
    }
}

fun getMax(v1: Int, v2: Int, v3: Int): Int {
    return when {
        v1 > v2 && v1 > v3 -> v1
        v2 > v3 -> v2
        else -> v3
    }
}
