package com.example.cursokotlin.Unit17

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

class Project86 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Project86(modifier = Modifier, navController = rememberNavController())
        }
    }
}

@Composable
fun Project86(modifier: Modifier = Modifier, navController: NavHostController) {
    var value1 by remember { mutableStateOf("") } // Input for the first value
    var value2 by remember { mutableStateOf("") } // Input for the second value
    var result by remember { mutableStateOf<String?>(null) } // Store the comparison result

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
            label = { Text("Enter the first value") },
            modifier = Modifier.fillMaxWidth()
        )

        // Input for the second value
        OutlinedTextField(
            value = value2,
            onValueChange = { value2 = it },
            label = { Text("Enter the second value") },
            modifier = Modifier.fillMaxWidth()
        )

        // Button to compare values
        Button(
            onClick = {
                if (value1.isNotEmpty() && value2.isNotEmpty()) {
                    result = "The greater value between $value1 and $value2 is ${returnGreater(value1.toInt(), value2.toInt())}"
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Compare Values")
        }

        // Display the comparison result
        result?.let { Text(it) }
    }
}

// Function to return the greater of two values
fun returnGreater(v1: Int, v2: Int) = if (v1 > v2) v1 else v2
