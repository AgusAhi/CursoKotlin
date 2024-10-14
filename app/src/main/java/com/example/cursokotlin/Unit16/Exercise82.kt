package com.example.cursokotlin.Unit16

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

class Project82 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Project82(modifier = Modifier, navController = rememberNavController())
        }
    }
}

@Composable
fun Project82(modifier: Modifier = Modifier, navController: NavHostController) {
    var value1 by remember { mutableStateOf("") } // Input for the first value
    var value2 by remember { mutableStateOf("") } // Input for the second value
    var value3 by remember { mutableStateOf("") } // Input for the third value
    var average by remember { mutableStateOf<String?>(null) } // Store the average result

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

        // Button to calculate the average
        Button(
            onClick = {
                if (value1.isNotEmpty() && value2.isNotEmpty() && value3.isNotEmpty()) {
                    average = returnAverage(value1.toInt(), value2.toInt(), value3.toInt()).toString()
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Calculate Average")
        }

        // Display the average result
        average?.let { Text("The average of the three numbers is $it") }
    }
}

// Function to calculate the average of three numbers
fun returnAverage(v1: Int, v2: Int, v3: Int): Int {
    return (v1 + v2 + v3) / 3
}
