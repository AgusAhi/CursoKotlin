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
fun Project117(modifier: Modifier = Modifier, navController: NavHostController) {
    var valor1 by remember { mutableStateOf(TextFieldValue("")) }
    var valor2 by remember { mutableStateOf(TextFieldValue("")) }
    var result by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(text = "Enter the first value:")
        BasicTextField(
            value = valor1,
            onValueChange = { valor1 = it },
            modifier = Modifier.fillMaxWidth()
        )

        Text(text = "Enter the second value:")
        BasicTextField(
            value = valor2,
            onValueChange = { valor2 = it },
            modifier = Modifier.fillMaxWidth()
        )

        Button(onClick = {
            val v1 = valor1.text.toIntOrNull() ?: 0
            val v2 = valor2.text.toIntOrNull() ?: 0
            result = performOperations(v1, v2)
        }) {
            Text(text = "Calculate")
        }

        if (result.isNotEmpty()) {
            Text(text = result)
        }
    }
}

fun performOperations(valor1: Int, valor2: Int): String {
    val sum = valor1 + valor2
    val difference = valor1 - valor2
    return "The sum of $valor1 and $valor2 is $sum\n" +
            "The difference between $valor1 and $valor2 is $difference"
}
