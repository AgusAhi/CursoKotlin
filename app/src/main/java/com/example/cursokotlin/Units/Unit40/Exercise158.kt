package com.example.cursokotlin.Units.Unit40

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

// Extension functions for string splitting
fun String.firstHalf(): String {
    return this.substring(0..this.length/2-1)
}

fun String.secondHalf(): String {
    return this.substring(this.length/2..this.length-1)
}

@Composable
fun Project158(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    var inputText by remember { mutableStateOf("") }
    var firstHalfResult by remember { mutableStateOf("") }
    var secondHalfResult by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        TextField(
            value = inputText,
            onValueChange = { inputText = it },
            label = { Text("Enter text to split") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                if (inputText.isNotEmpty()) {
                    firstHalfResult = inputText.firstHalf()
                    secondHalfResult = inputText.secondHalf()
                }
            }
        ) {
            Text("Split Text")
        }

        if (firstHalfResult.isNotEmpty() || secondHalfResult.isNotEmpty()) {
            Text("First Half: $firstHalfResult")
            Text("Second Half: $secondHalfResult")
        }
    }
}