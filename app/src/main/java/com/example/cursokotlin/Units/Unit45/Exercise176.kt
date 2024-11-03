package com.example.cursokotlin.Units.Unit45

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import kotlin.random.Random

@Composable
fun Project176(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    var diceRolls by remember { mutableStateOf(MutableList(20) { ((Math.random() * 6) + 1).toInt() }) }
    var numberOfOnes by remember { mutableStateOf(0) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Dice Rolls Simulator",
            style = MaterialTheme.typography.titleLarge
        )

        // Display current list
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "Current Rolls:",
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = diceRolls.toString(),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }

        // Button to generate new rolls
        Button(
            onClick = {
                diceRolls = MutableList(20) { ((Math.random() * 6) + 1).toInt() }
                numberOfOnes = diceRolls.count { it == 1 }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Generate New Rolls")
        }

        // Display count of ones
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "Number of Ones:",
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = numberOfOnes.toString(),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }

        // Button to remove sixes - FIXED VERSION
        Button(
            onClick = {
                diceRolls = diceRolls.filter { it != 6 }.toMutableList()
                numberOfOnes = diceRolls.count { it == 1 }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Remove All Sixes")
        }

        // Statistics
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "Statistics:",
                    style = MaterialTheme.typography.titleMedium
                )
                Text("Total rolls: ${diceRolls.size}")
                Text("Ones: ${diceRolls.count { it == 1 }}")
                Text("Twos: ${diceRolls.count { it == 2 }}")
                Text("Threes: ${diceRolls.count { it == 3 }}")
                Text("Fours: ${diceRolls.count { it == 4 }}")
                Text("Fives: ${diceRolls.count { it == 5 }}")
                Text("Sixes: ${diceRolls.count { it == 6 }}")
            }
        }
    }
}