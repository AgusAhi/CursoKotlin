package com.example.cursokotlin.Units.Unit47

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun Project189(modifier: Modifier = Modifier, navController: NavHostController) {
    var carton by remember { mutableStateOf(mutableSetOf<Int>()) }
    var bolillero by remember { mutableStateOf(mutableSetOf<Int>()) }
    var gameStatus by remember { mutableStateOf("") }
    var isSimulating by remember { mutableStateOf(false) }
    var drawnNumbers by remember { mutableStateOf(listOf<Int>()) }
    val scope = rememberCoroutineScope()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Lottery Simulation",
            style = MaterialTheme.typography.headlineMedium
        )

        // Generate Ticket Button
        Button(
            onClick = {
                carton = generateTicket()
                bolillero.clear()
                drawnNumbers = emptyList()
                gameStatus = ""
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Generate New Ticket")
        }

        // Display Ticket
        if (carton.isNotEmpty()) {
            Card(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        "Your Lottery Ticket",
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    LazyHorizontalGrid(
                        rows = GridCells.Fixed(2),
                        modifier = Modifier.height(80.dp)
                    ) {
                        items(carton.toList()) { number ->
                            NumberBubble(
                                number = number,
                                isHighlighted = number in drawnNumbers
                            )
                        }
                    }
                }
            }
        }

        // Simulate Drawing Button
        Button(
            onClick = {
                scope.launch {
                    isSimulating = true
                    bolillero = generateDrum()
                    simulateDrawing(
                        cardboard = carton,
                        bobbin = bolillero,
                        onNumberDrawn = { number, attempts, matches ->
                            drawnNumbers = drawnNumbers + number
                            if (matches == 6) {
                                gameStatus = "Winner! It took $attempts draws to win."
                                isSimulating = false
                            }
                        }
                    )
                }
            },
            enabled = carton.isNotEmpty() && !isSimulating,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(if (isSimulating) "Simulating..." else "Start Drawing")
        }

        // Drawn Numbers Display
        if (drawnNumbers.isNotEmpty()) {
            Card(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        "Drawn Numbers",
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    LazyHorizontalGrid(
                        rows = GridCells.Fixed(4),
                        modifier = Modifier.height(160.dp)
                    ) {
                        items(drawnNumbers) { number ->
                            NumberBubble(
                                number = number,
                                isHighlighted = number in carton
                            )
                        }
                    }
                }
            }
        }

        // Game Status
        if (gameStatus.isNotEmpty()) {
            Text(
                text = gameStatus,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Composable
private fun NumberBubble(
    number: Int,
    isHighlighted: Boolean,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier.padding(4.dp),
        shape = MaterialTheme.shapes.medium,
        color = if (isHighlighted)
            MaterialTheme.colorScheme.primaryContainer
        else
            MaterialTheme.colorScheme.surfaceVariant
    ) {
        Text(
            text = number.toString(),
            modifier = Modifier.padding(8.dp),
            textAlign = TextAlign.Center,
            color = if (isHighlighted)
                MaterialTheme.colorScheme.onPrimaryContainer
            else
                MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

private fun generateTicket(): MutableSet<Int> {
    val ticket = mutableSetOf<Int>()
    while (ticket.size != 6) {
        val value = ((Math.random() * 50) + 1).toInt()
        ticket.add(value)
    }
    return ticket
}

private fun generateDrum(): MutableSet<Int> {
    val drum = mutableSetOf<Int>()
    while (drum.size != 50) {
        val value = ((Math.random() * 50) + 1).toInt()
        drum.add(value)
    }
    return drum
}

private suspend fun simulateDrawing(
    cardboard: Set<Int>,
    bobbin: Set<Int>,
    onNumberDrawn: (number: Int, attempts: Int, matches: Int) -> Unit
) {
    var matches = 0
    var attempts = 0

    for (number in bobbin) {
        attempts++
        delay(500) // Add delay for visual effect

        onNumberDrawn(number, attempts, matches)

        if (number in cardboard) {
            matches++
            if (matches == 6) break
        }
    }
}