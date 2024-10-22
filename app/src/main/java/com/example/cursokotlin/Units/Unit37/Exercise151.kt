package com.example.cursokotlin.Units.Unit37

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun Project151(modifier: Modifier = Modifier, navController: NavHostController) {
    var inputText by remember { mutableStateOf("Is this test 1 or test 2?") }
    var outputText by remember { mutableStateOf("") }

    // Helper function to filter characters based on a condition
    fun filter(text: String, fn: (Char) -> Boolean): String {
        return text.filter(fn)
    }

    Column(
        modifier = modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        TextField(
            value = inputText,
            onValueChange = { inputText = it },
            label = { Text("Enter text to filter") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(onClick = {
            outputText = buildString {
                append("Original String:\n")
                append("$inputText\n\n")

                // Filter vowels
                val result1 = filter(inputText) { char ->
                    char.lowercaseChar() in setOf('a', 'e', 'i', 'o', 'u')
                }
                append("Only vowels:\n")
                append("$result1\n\n")

                // Filter lowercase letters
                val result2 = filter(inputText) { char ->
                    char in 'a'..'z'
                }
                append("Only lowercase characters:\n")
                append("$result2\n\n")

                // Filter non-alphabetic characters
                val result3 = filter(inputText) { char ->
                    char !in 'a'..'z' && char !in 'A'..'Z'
                }
                append("Only non-alphabetic characters:\n")
                append("$result3")
            }
        }) {
            Text("Filter Text")
        }

        Text(
            text = outputText,
            modifier = Modifier.padding(top = 16.dp)
        )
    }
}