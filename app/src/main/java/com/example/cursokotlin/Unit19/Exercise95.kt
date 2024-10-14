package com.example.cursokotlin.Unit19

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

class Project95 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Project95(modifier = Modifier, navController = rememberNavController()) // Call the Project94 function directly
        }
    }
}

@Composable
fun Project95(modifier: Modifier = Modifier, navController: NavHostController) {
    var number by remember { mutableStateOf("") } // Store the input number
    var terms by remember { mutableStateOf("") } // Store the input number of terms
    var result by remember { mutableStateOf("") } // Store the result string

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Input field for the number
        OutlinedTextField(
            value = number,
            onValueChange = { number = it },
            label = { Text("Enter a number") },
            modifier = Modifier.fillMaxWidth()
        )

        // Input field for the number of terms
        OutlinedTextField(
            value = terms,
            onValueChange = { terms = it },
            label = { Text("Enter number of terms (default 10)") },
            modifier = Modifier.fillMaxWidth()
        )

        // Button to generate the multiplication table
        Button(
            onClick = {
                val termCount = terms.toIntOrNull() ?: 10 // Default to 10 if input is invalid
                result = generateTable(number.toIntOrNull() ?: 0, termCount)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Generate Table")
        }

        // Display the result
        Text(result)
    }
}

// Function to generate multiplication table
fun generateTable(number: Int, terms: Int = 10): String {
    val table = StringBuilder()
    for (i in 1..terms) {
        table.append("${number * i}\n")
    }
    return table.toString()
}
