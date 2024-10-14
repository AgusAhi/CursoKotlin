package com.example.cursokotlin.Unit16

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

class Project83 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Project83(modifier = Modifier, navController = rememberNavController())
        }
    }
}

@Composable
fun Project83(modifier: Modifier = Modifier, navController: NavHostController) {
    var side by remember { mutableStateOf("") } // Input for the side of the square
    var perimeter by remember { mutableStateOf<String?>(null) } // Store the calculated perimeter

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Input for the side of the square
        OutlinedTextField(
            value = side,
            onValueChange = { side = it },
            label = { Text("Enter the side of the square") },
            modifier = Modifier.fillMaxWidth()
        )

        // Button to calculate the perimeter
        Button(
            onClick = {
                if (side.isNotEmpty()) {
                    perimeter = returnPerimeter(side.toInt()).toString()
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Calculate Perimeter")
        }

        // Display the calculated perimeter
        perimeter?.let { Text("The perimeter of the square is $it") }
    }
}

// Function to calculate the perimeter of a square
fun returnPerimeter(side: Int): Int {
    return side * 4
}
