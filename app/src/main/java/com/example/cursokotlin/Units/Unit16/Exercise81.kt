package com.example.cursokotlin.Units.Unit16

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
fun Project81(modifier: Modifier = Modifier, navController: NavHostController) {
    var name1 by remember { mutableStateOf("") } // Input for the first name
    var name2 by remember { mutableStateOf("") } // Input for the second name
    var result by remember { mutableStateOf<String?>(null) } // Store the result

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Input for the first name
        OutlinedTextField(
            value = name1,
            onValueChange = { name1 = it },
            label = { Text("Enter the first name") },
            modifier = Modifier.fillMaxWidth()
        )

        // Input for the second name
        OutlinedTextField(
            value = name2,
            onValueChange = { name2 = it },
            label = { Text("Enter the second name") },
            modifier = Modifier.fillMaxWidth()
        )

        // Button to compare the names
        Button(
            onClick = {
                result = compareNames(name1, name2)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Compare Names")
        }

        // Display the result
        result?.let { Text(it) }
    }
}

// Function to return the length of a name
fun large(name: String): Int {
    return name.length
}

// Function to compare the lengths of two names
fun compareNames(name1: String, name2: String): String {
    return if (large(name1) == large(name2)) {
        "Both names: $name1 and $name2 have the same number of characters"
    } else if (large(name1) > large(name2)) {
        "$name1 is longer"
    } else {
        "$name2 is longer"
    }
}

