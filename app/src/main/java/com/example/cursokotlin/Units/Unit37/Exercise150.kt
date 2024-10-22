package com.example.cursokotlin.Units.Unit37

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import kotlin.random.Random

@Composable
fun Project150(modifier: Modifier = Modifier, navController: NavHostController) {
    var numbers by remember { mutableStateOf(IntArray(10) { Random.nextInt(100) }) }
    var selectedFilter by remember { mutableStateOf(0) }

    // Filters list definition
    val filters = listOf(
        "Multiples of 2" to { x: Int -> x % 2 == 0 },
        "Multiples of 3 or 5" to { x: Int -> x % 3 == 0 || x % 5 == 0 },
        "Greater than or equal to 50" to { x: Int -> x >= 50 },
        "Values in ranges (1-10, 20-30, 90-95)" to { x: Int ->
            when (x) {
                in 1..10, in 20..30, in 90..95 -> true
                else -> false
            }
        },
        "All values" to { _: Int -> true }
    )

    // Recalculate filtered numbers based on the selected filter
    val filteredNumbers by remember(selectedFilter, numbers) {
        derivedStateOf {
            filters[selectedFilter].second.let { filter ->
                numbers.filter(filter).joinToString(" ")
            }
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = "Array Filter Viewer",
            style = MaterialTheme.typography.headlineMedium
        )

        // Display original array
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "Original Array:",
                    style = MaterialTheme.typography.titleMedium
                )
                Text(numbers.joinToString(" "))
            }
        }

        // Filter options
        LazyColumn(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(filters.withIndex().toList()) { (index, filter) ->
                ElevatedButton(
                    onClick = {
                        selectedFilter = index
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(filter.first)
                }
            }
        }

        // Results
        if (filteredNumbers.isNotEmpty()) {
            Card(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = "Filtered Results:",
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(filteredNumbers)
                }
            }
        }

        // Generate new numbers button
        OutlinedButton(
            onClick = {
                numbers = IntArray(10) { Random.nextInt(100) }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Generate New Numbers")
        }
    }
}
