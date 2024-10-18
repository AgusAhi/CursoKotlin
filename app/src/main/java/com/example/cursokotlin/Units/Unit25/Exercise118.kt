package com.example.cursokotlin.Units.Unit25

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.* // For layout management
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.* // Material 3 for UI components
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun Project118(modifier: Modifier = Modifier, navController: NavHostController) {
    // We use a list of TextFieldValue to capture the ages input from the user
    val ages = remember { List(5) { mutableStateOf(TextFieldValue("")) } }
    var result by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(text = "Enter the ages of 5 children:")
        // Create input fields for each child's age
        for (i in ages.indices) {
            BasicTextField(
                value = ages[i].value,
                onValueChange = { ages[i].value = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                decorationBox = { innerTextField ->
                    Box(Modifier.padding(8.dp)) {
                        if (ages[i].value.text.isEmpty()) {
                            Text(text = "Enter age ${i + 1}")
                        }
                        innerTextField()
                    }
                }
            )
        }

        Button(onClick = {
            val intAges = ages.map { it.value.text.toIntOrNull() ?: 0 }
            result = calculateAges(intAges)
        }) {
            Text(text = "Calculate")
        }

        if (result.isNotEmpty()) {
            Text(text = result)
        }
    }
}

fun calculateAges(ages: List<Int>): String {
    if (ages.isEmpty()) return "No ages entered"

    // Find the oldest age
    val oldest = ages.maxOrNull() ?: 0
    // Calculate the average age
    val average = if (ages.isNotEmpty()) ages.sum() / ages.size else 0

    return "The oldest child is $oldest years old.\n" +
            "The average age of the children is $average."
}
