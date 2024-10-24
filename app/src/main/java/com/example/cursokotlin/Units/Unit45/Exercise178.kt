package com.example.cursokotlin.Units.Unit45

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun Project178(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    var numbers by remember {
        mutableStateOf(List(100) { (Math.random() * 21).toInt() })
    }

    val range1Count = numbers.count { it in 1..4 }
    val range2Count = numbers.count { it in 5..8 }
    val range3Count = numbers.count { it in 10..13 }
    val contains20 = numbers.contains(20)

    val maxCount = maxOf(range1Count, range2Count, range3Count)

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Random Number Analysis",
            style = MaterialTheme.typography.headlineMedium
        )

        // Bar Chart
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        ) {
            Canvas(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                val barWidth = size.width / 4
                val maxHeight = size.height

                // Draw bars
                drawRect(
                    color = Color(0xFF6200EE),
                    topLeft = Offset(barWidth * 0.5f, maxHeight * (1 - range1Count.toFloat() / maxCount)),
                    size = Size(barWidth * 0.8f, maxHeight * range1Count.toFloat() / maxCount)
                )

                drawRect(
                    color = Color(0xFF3700B3),
                    topLeft = Offset(barWidth * 1.7f, maxHeight * (1 - range2Count.toFloat() / maxCount)),
                    size = Size(barWidth * 0.8f, maxHeight * range2Count.toFloat() / maxCount)
                )

                drawRect(
                    color = Color(0xFF03DAC5),
                    topLeft = Offset(barWidth * 2.9f, maxHeight * (1 - range3Count.toFloat() / maxCount)),
                    size = Size(barWidth * 0.8f, maxHeight * range3Count.toFloat() / maxCount)
                )
            }
        }

        // Statistics Cards
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            StatCard(
                title = "Range 1-4",
                count = range1Count,
                modifier = Modifier.weight(1f)
            )
            StatCard(
                title = "Range 5-8",
                count = range2Count,
                modifier = Modifier.weight(1f)
            )
            StatCard(
                title = "Range 10-13",
                count = range3Count,
                modifier = Modifier.weight(1f)
            )
        }

        // Contains 20 Status
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = if (contains20) Color(0xFF4CAF50) else Color(0xFFF44336)
            )
        ) {
            Text(
                text = if (contains20) "List contains 20" else "List does not contain 20",
                modifier = Modifier.padding(16.dp),
                color = Color.White
            )
        }

        // Number List Preview
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "Generated Numbers Preview",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    items(numbers.take(20).size) { index ->
                        Card(
                            colors = CardDefaults.cardColors(
                                containerColor = MaterialTheme.colorScheme.surfaceVariant
                            )
                        ) {
                            Text(
                                text = "${numbers[index]}",
                                modifier = Modifier.padding(8.dp)
                            )
                        }
                    }
                }
            }
        }

        // Generate New Numbers Button
        Button(
            onClick = {
                numbers = List(100) { (Math.random() * 21).toInt() }
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Generate New Numbers")
        }
    }
}

@Composable
private fun StatCard(
    title: String,
    count: Int,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleSmall
            )
            Text(
                text = count.toString(),
                style = MaterialTheme.typography.headlineMedium
            )
        }
    }
}