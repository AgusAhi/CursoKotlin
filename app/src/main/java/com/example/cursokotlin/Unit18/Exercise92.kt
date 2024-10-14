package com.example.cursokotlin.Unit18

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

class Project92 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Project92(modifier = Modifier, navController = rememberNavController())
        }
    }
}

@Composable
fun Project92(modifier: Modifier = Modifier, navController: NavHostController) {
    var title by remember { mutableStateOf("") } // Store the title input
    var character by remember { mutableStateOf("*") } // Store the character input
    var output by remember { mutableStateOf("") } // Store the output string

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Input for the title
        OutlinedTextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("Enter Title") },
            modifier = Modifier.fillMaxWidth()
        )

        // Input for the underline character
        OutlinedTextField(
            value = character,
            onValueChange = { character = it },
            label = { Text("Enter Underline Character (default '*')") },
            modifier = Modifier.fillMaxWidth()
        )

        // Button to generate the title with underline
        Button(
            onClick = {
                output = generateUnderlinedTitle(title, character)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Generate Title")
        }

        // Display the output
        Text(output)
    }
}

// Function to generate the underlined title
fun generateUnderlinedTitle(title: String, character: String = "*"): String {
    val underline = character.repeat(title.length)
    return "$title\n$underline"
}
