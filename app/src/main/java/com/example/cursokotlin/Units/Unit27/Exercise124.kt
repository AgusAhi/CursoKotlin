package com.example.cursokotlin.Units.Unit27

import androidx.compose.foundation.layout.* // For layout management
import androidx.compose.material3.* // Material 3 for UI components
import androidx.compose.runtime.* // For managing state
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import kotlin.random.Random

// Composable function for the main UI
@Composable
fun Project124(modifier: Modifier = Modifier, navController: NavHostController) {
    val vector = remember { Vector() }
    var vectorDisplay by remember { mutableStateOf("") }
    var maxElement by remember { mutableStateOf("") }
    var minElement by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
    ) {
        Text(text = "Array Operations", style = MaterialTheme.typography.titleLarge)

        // Button to display the vector elements, max, and min
        Button(onClick = {
            vectorDisplay = vector.showPrint()
            maxElement = vector.showGreater()
            minElement = vector.showLower()
        }) {
            Text(text = "Show Array Information")
        }

        // Display the results
        Spacer(modifier = Modifier.height(16.dp))

        if (vectorDisplay.isNotEmpty()) {
            Text(text = "Array: $vectorDisplay")
        }
        if (maxElement.isNotEmpty()) {
            Text(text = "Maximum element: $maxElement")
        }
        if (minElement.isNotEmpty()) {
            Text(text = "Minimum element: $minElement")
        }
    }
}

// Class for managing a vector of integers
class Vector {
    private val vec = IntArray(5)

    init {
        load()
    }

    // Function to load random values into the array
    private fun load() {
        for (i in vec.indices) {
            vec[i] = Random.nextInt(0, 11)  // Random value between 0 and 10
        }
    }

    // Function to return the array as a string for displaying
    fun showPrint(): String {
        return vec.joinToString(separator = " - ")
    }

    // Function to return the maximum element of the array
    fun showGreater(): String {
        val max = vec.maxOrNull() ?: 0
        return max.toString()
    }

    // Function to return the minimum element of the array
    fun showLower(): String {
        val min = vec.minOrNull() ?: 0
        return min.toString()
    }
}
