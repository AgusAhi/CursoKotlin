package com.example.cursokotlin.Units.Unit26

import androidx.compose.foundation.layout.* // For layout management
import androidx.compose.material3.* // Material 3 for UI components
import androidx.compose.runtime.* // For managing state
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import kotlin.random.Random

// Composable function for the main UI
@Composable
fun Project120(modifier: Modifier = Modifier, navController: NavHostController) {
    val diceGame = remember { DiceGame() }
    var result by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
    ) {
        Text(text = "Dice Game", style = MaterialTheme.typography.titleLarge)

        Button(onClick = {
            result = diceGame.play()
        }) {
            Text(text = "Roll the Dice")
        }

        if (result.isNotEmpty()) {
            Text(text = result)
        }

        Text(text = "Dice 1: ${diceGame.dice1.value}")
        Text(text = "Dice 2: ${diceGame.dice2.value}")
        Text(text = "Dice 3: ${diceGame.dice3.value}")
    }
}

// Dice class
class Dice(var value: Int) {
    // Function to simulate rolling the dice
    fun roll() {
        value = Random.nextInt(1, 7)  // Generates a random number between 1 and 6
    }
}

// Class for the dice game logic
class DiceGame {
    val dice1 = Dice(1)
    val dice2 = Dice(1)
    val dice3 = Dice(1)

    // Function to simulate the game and return the result
    fun play(): String {
        dice1.roll()
        dice2.roll()
        dice3.roll()

        return if (dice1.value == dice2.value && dice2.value == dice3.value) {
            "You Won! All dice show ${dice1.value}."
        } else {
            "You Lost. Dice show ${dice1.value}, ${dice2.value}, and ${dice3.value}."
        }
    }
}
