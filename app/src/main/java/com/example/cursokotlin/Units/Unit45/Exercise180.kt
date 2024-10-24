package com.example.cursokotlin.Units.Unit45

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun Project180(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    var heights by remember { mutableStateOf(listOf<Float>()) }
    var newHeight by remember { mutableStateOf("") }

    val average = heights.takeIf { it.isNotEmpty() }?.average() ?: 0.0
    val aboveAverage = heights.count { it > average }
    val belowAverage = heights.count { it < average }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Height Analysis Tool",
            style = MaterialTheme.typography.headlineMedium
        )

        // Input Section
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                OutlinedTextField(
                    value = newHeight,
                    onValueChange = { newHeight = it },
                    label = { Text("Enter height (e.g., 1.92)") },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true
                )

                Button(
                    onClick = {
                        newHeight.toFloatOrNull()?.let { height ->
                            if (height > 0 && height < 3.0) {  // Basic validation
                                heights = heights + height
                                newHeight = ""
                            }
                        }
                    },
                    enabled = heights.size < 5,
                    modifier = Modifier.align(Alignment.End)
                ) {
                    Text(if (heights.size < 5) "Add Height (${5 - heights.size} remaining)" else "All heights recorded")
                }
            }
        }

        // Statistics Card
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "Statistics",
                    style = MaterialTheme.typography.titleMedium
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text("Average")
                        Text(
                            String.format("%.2f m", average),
                            style = MaterialTheme.typography.titleLarge,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text("Above Avg")
                        Text(
                            aboveAverage.toString(),
                            style = MaterialTheme.typography.titleLarge,
                            color = Color(0xFF4CAF50)
                        )
                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text("Below Avg")
                        Text(
                            belowAverage.toString(),
                            style = MaterialTheme.typography.titleLarge,
                            color = Color(0xFFF44336)
                        )
                    }
                }

                // Height Distribution Visualization
                if (heights.isNotEmpty()) {
                    Canvas(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(150.dp)
                            .padding(top = 16.dp)
                    ) {
                        val minHeight = heights.minOrNull() ?: 0f
                        val maxHeight = heights.maxOrNull() ?: 0f
                        val range = maxHeight - minHeight

                        // Draw average line
                        drawLine(
                            color = Color.Red,
                            start = Offset(0f, size.height * (1 - (average.toFloat() - minHeight) / range)),
                            end = Offset(size.width, size.height * (1 - (average.toFloat() - minHeight) / range)),
                            strokeWidth = 2f
                        )

                        // Draw height bars
                        val barWidth = size.width / heights.size
                        heights.forEachIndexed { index, height ->
                            val normalizedHeight = (height - minHeight) / range
                            drawRect(
                                color = if (height > average) Color(0xFF4CAF50) else Color(0xFFF44336),
                                topLeft = Offset(
                                    index * barWidth,
                                    size.height * (1 - normalizedHeight)
                                ),
                                size = Size(
                                    barWidth * 0.8f,
                                    size.height * normalizedHeight
                                )
                            )
                        }
                    }
                }
            }
        }

        // Heights List
        Card(
            modifier = Modifier.weight(1f)
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(heights.mapIndexed { index, height -> index to height }) { (index, height) ->
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.surfaceVariant
                        )
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text("Person ${index + 1}")
                            Text(
                                String.format("%.2f m", height),
                                style = MaterialTheme.typography.titleMedium
                            )
                        }
                    }
                }
            }
        }
    }
}