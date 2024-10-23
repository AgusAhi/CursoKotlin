package com.example.cursokotlin.Units.Unit40

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

// Extension function for printing array
fun IntArray.printArray(): String {
    return buildString {
        append("[")
        this@printArray.forEachIndexed { index, element ->
            append(element)
            if (index < this@printArray.size - 1) {
                append(" ")
            }
        }
        append("]")
    }
}

@Composable
fun Project159(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    var arrayResult by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Button(
            onClick = {
                val array = IntArray(10) { it }  // Creates array [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
                arrayResult = array.printArray()
            }
        ) {
            Text("Generate and Print Array")
        }

        if (arrayResult.isNotEmpty()) {
            Text(
                text = "Array Content: $arrayResult",
                modifier = Modifier.padding(top = 16.dp)
            )
        }
    }
}
