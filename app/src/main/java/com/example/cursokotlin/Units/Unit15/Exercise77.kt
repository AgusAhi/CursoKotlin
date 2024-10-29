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
fun Project77(modifier: Modifier = Modifier, navController: NavHostController) {
    var key1 by remember { mutableStateOf("") } // Input for first key
    var key2 by remember { mutableStateOf("") } // Input for second key
    var result by remember { mutableStateOf<String?>(null) } // Store result

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Input for the first key
        OutlinedTextField(
            value = key1,
            onValueChange = { key1 = it },
            label = { Text("Enter first key") },
            modifier = Modifier.fillMaxWidth()
        )

        // Input for the second key
        OutlinedTextField(
            value = key2,
            onValueChange = { key2 = it },
            label = { Text("Re-enter the same key") },
            modifier = Modifier.fillMaxWidth()
        )

        // Button to verify keys
        Button(
            onClick = {
                result = verifyKeys(key1, key2)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Verify Keys")
        }

        // Display the result
        result?.let { Text(it) }
    }
}

// Function to verify if both keys are the same
fun verifyKeys(key1: String, key2: String): String {
    return if (key1 == key2) {
        "The same key was entered twice"
    } else {
        "The keys entered are not the same"
    }
}
