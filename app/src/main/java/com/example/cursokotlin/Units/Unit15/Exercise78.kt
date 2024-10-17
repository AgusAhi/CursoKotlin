package com.example.cursokotlin.Units.Unit15

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

@Composable
fun Project78(modifier: Modifier = Modifier, navController: NavHostController) {
    var value1 by remember { mutableStateOf("") } // Input for the first value
    var value2 by remember { mutableStateOf("") } // Input for the second value
    var value3 by remember { mutableStateOf("") } // Input for the third value
    var result by remember { mutableStateOf<String?>(null) } // Store the result

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Input for the first value
        OutlinedTextField(
            value = value1,
            onValueChange = { value1 = it },
            label = { Text("Enter first value") },
            modifier = Modifier.fillMaxWidth()
        )

        // Input for the second value
        OutlinedTextField(
            value = value2,
            onValueChange = { value2 = it },
            label = { Text("Enter second value") },
            modifier = Modifier.fillMaxWidth()
        )

        // Input for the third value
        OutlinedTextField(
            value = value3,
            onValueChange = { value3 = it },
            label = { Text("Enter third value") },
            modifier = Modifier.fillMaxWidth()
        )

        // Button to order the values
        Button(
            onClick = {
                result = orderDescending(value1.toInt(), value2.toInt(), value3.toInt())
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Order")
        }

        // Display the result
        result?.let { Text("Ordered: $it") }
    }
}

// Function to order values from greater to lesser
fun orderDescending(value1: Int, value2: Int, value3: Int): String {
    return when {
        value1 >= value2 && value1 >= value3 -> {
            if (value2 >= value3) "$value1 $value2 $value3"
            else "$value1 $value3 $value2"
        }
        value2 >= value1 && value2 >= value3 -> {
            if (value1 >= value3) "$value2 $value1 $value3"
            else "$value2 $value3 $value1"
        }
        else -> {
            if (value1 >= value2) "$value3 $value1 $value2"
            else "$value3 $value2 $value1"
        }
    }
}
