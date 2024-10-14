package com.example.cursokotlin.Unit21

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
import kotlin.math.round

class Project99 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Project99(modifier = Modifier, navController = rememberNavController())
        }
    }
}

@Composable
fun Project99(modifier: Modifier = Modifier, navController: NavHostController) {
    var heightInput by remember { mutableStateOf("") }
    var heights by remember { mutableStateOf(FloatArray(5)) }
    var currentIndex by remember { mutableStateOf(0) }
    var inputComplete by remember { mutableStateOf(false) }
    var result by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Enter heights of 5 people")

        OutlinedTextField(
            value = heightInput,
            onValueChange = { heightInput = it },
            label = { Text("Enter height ${currentIndex + 1} (in cm)") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                val height = heightInput.toFloatOrNull()
                if (height != null) {
                    heights[currentIndex] = height
                    currentIndex++
                    heightInput = ""
                    if (currentIndex == 5) {
                        inputComplete = true
                        result = calculateHeightStats(heights)
                    }
                }
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = !inputComplete && heightInput.isNotEmpty()
        ) {
            Text("Submit (${currentIndex}/5)")
        }

        if (inputComplete) {
            Text(result)

            Button(
                onClick = {
                    heights = FloatArray(5)
                    currentIndex = 0
                    inputComplete = false
                    result = ""
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Reset")
            }
        }
    }
}

fun calculateHeightStats(heights: FloatArray): String {
    val average = heights.average().toFloat()
    val aboveAverage = heights.count { it > average }
    val belowAverage = heights.count { it <= average }

    return """
        Average height: ${round(average * 10) / 10} cm
        Number of people above average height: $aboveAverage
        Number of people below or equal to average height: $belowAverage
    """.trimIndent()
}