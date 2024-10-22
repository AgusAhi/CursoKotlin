package com.example.cursokotlin.Units.Unit35

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import kotlin.random.Random

class Die(var value: Int = 1) {
    fun roll() {
        value = Random.nextInt(1, 7)
    }
}

@Composable
fun DieDisplay(
    die: Die,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.aspectRatio(1f),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        )
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "${die.value}",
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
        }
    }
}

@Composable
fun Project146(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    var dice by remember {
        mutableStateOf(Array(5) { Die() })
    }

    var rollCount by remember { mutableStateOf(0) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Dice Rolling Simulation",
            style = MaterialTheme.typography.headlineMedium,
            textAlign = TextAlign.Center
        )

        if (rollCount > 0) {
            Text(
                text = "Roll #$rollCount",
                style = MaterialTheme.typography.titleMedium
            )
        }

        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 80.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            items(dice) { die ->
                DieDisplay(die = die)
            }
        }

        Button(
            onClick = {
                dice = dice.map { die ->
                    die.also { it.roll() }
                }.toTypedArray()
                rollCount++
            }
        ) {
            Text("Roll All Dice")
        }

        if (rollCount > 0) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.secondaryContainer
                )
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = "Results",
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        text = "Sum: ${dice.sumOf { it.value }}",
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Text(
                        text = "Average: ${"%.2f".format(dice.map { it.value }.average())}",
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
        }
    }
}