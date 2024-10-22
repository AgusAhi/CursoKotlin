package com.example.cursokotlin.Units.Unit39

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import kotlin.random.Random

data class Dice(var value: Int = 1) {
    fun roll() {
        value = Random.nextInt(1, 7)
    }
}

@Composable
fun Project157(modifier: Modifier = Modifier, navController: NavHostController) {
    var dice by remember {
        mutableStateOf(Array(5) { Dice() })
    }

    var diceCount by remember {
        mutableStateOf(mapOf(
            1 to 0, 2 to 0, 3 to 0,
            4 to 0, 5 to 0, 6 to 0
        ))
    }

    Column(
        modifier = modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Roll button
        Button(
            onClick = {
                dice.forEach { it.roll() }
                // Update counts
                diceCount = (1..6).associateWith { value ->
                    dice.count { it.value == value }
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Roll All Dice")
        }

        // Dice grid
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(5),
                modifier = Modifier.padding(16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(dice) { die ->
                    DiceDisplay(die)
                }
            }
        }

        // Statistics card
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    "Dice Statistics",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                // Grid for statistics
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    for (value in 1..3) {
                        StatisticColumn(value, diceCount[value] ?: 0)
                    }
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    for (value in 4..6) {
                        StatisticColumn(value, diceCount[value] ?: 0)
                    }
                }
            }
        }
    }
}

@Composable
fun DiceDisplay(dice: Dice) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        )
    ) {
        Box(
            modifier = Modifier
                .aspectRatio(1f)
                .padding(8.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = dice.value.toString(),
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun StatisticColumn(value: Int, count: Int) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Value: $value",
            style = MaterialTheme.typography.bodySmall
        )
        Text(
            "Count: $count",
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Bold
        )
    }
}