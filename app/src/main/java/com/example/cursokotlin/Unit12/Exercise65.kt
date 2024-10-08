package com.example.cursokotlin.Unit5

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

class Exercise65 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Project65(modifier = Modifier, navController = rememberNavController())
        }
    }
}

@Composable
fun Project65(modifier: Modifier = Modifier, navController: NavHostController) {
    var countEquilateral by remember { mutableStateOf(0) }
    var countIsosceles by remember { mutableStateOf(0) }
    var countScalene by remember { mutableStateOf(0) }
    var numberOfTriangles by remember { mutableStateOf("") }
    var trianglesProcessed by remember { mutableStateOf(0) }

    // This will hold the result text to display
    var resultText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Input for number of triangles
        if (trianglesProcessed == 0) {
            Text("Enter the number of triangles:")
            OutlinedTextField(
                value = numberOfTriangles,
                onValueChange = { numberOfTriangles = it },
                label = { Text("Number of triangles") },
                modifier = Modifier.fillMaxWidth()
            )

            Button(
                onClick = {
                    trianglesProcessed = numberOfTriangles.toIntOrNull() ?: 0
                    numberOfTriangles = ""
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Start Input")
            }
        }

        // Input for triangle sides
        if (trianglesProcessed > 0) {
            Text("Enter the sides of triangle ${trianglesProcessed - countEquilateral - countIsosceles - countScalene + 1}:")
            var side1 by remember { mutableStateOf("") }
            var side2 by remember { mutableStateOf("") }
            var side3 by remember { mutableStateOf("") }

            OutlinedTextField(
                value = side1,
                onValueChange = { side1 = it },
                label = { Text("Side 1") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = side2,
                onValueChange = { side2 = it },
                label = { Text("Side 2") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = side3,
                onValueChange = { side3 = it },
                label = { Text("Side 3") },
                modifier = Modifier.fillMaxWidth()
            )

            Button(
                onClick = {
                    val s1 = side1.toIntOrNull() ?: 0
                    val s2 = side2.toIntOrNull() ?: 0
                    val s3 = side3.toIntOrNull() ?: 0

                    when {
                        s1 == s2 && s1 == s3 -> {
                            countEquilateral++
                        }
                        s1 == s2 || s1 == s3 || s2 == s3 -> {
                            countIsosceles++
                        }
                        else -> {
                            countScalene++
                        }
                    }

                    // Clear inputs for the next triangle
                    side1 = ""
                    side2 = ""
                    side3 = ""

                    if (countEquilateral + countIsosceles + countScalene == trianglesProcessed) {
                        // Update result text when all triangles are processed
                        resultText = """
                            Number of equilateral triangles: $countEquilateral
                            Number of isosceles triangles: $countIsosceles
                            Number of scalene triangles: $countScalene
                        """.trimIndent()
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Submit Triangle")
            }
        }

        // Display results
        if (resultText.isNotEmpty()) {
            Text(resultText, modifier = Modifier.padding(top = 16.dp))
        }
    }
}
