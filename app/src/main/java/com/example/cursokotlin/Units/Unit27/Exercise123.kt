package com.example.cursokotlin.Units.Unit27

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.* // For layout management
import androidx.compose.material3.* // Material 3 for UI components
import androidx.compose.runtime.* // For managing state
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlin.random.Random

// Composable function for the main UI
@Composable
fun Project123(modifier: Modifier = Modifier, navController: NavHostController) {
    var diceValue by remember { mutableStateOf(1) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
    ) {
        Text(text = "Dice Roll", style = MaterialTheme.typography.titleLarge)

        // Button to roll the dice
        Button(onClick = {
            diceValue = rollDice()
        }) {
            Text(text = "Roll the Dice")
        }

        // Display the result
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "**************************************")
        Text(text = "Dice Value: $diceValue")
        Text(text = "**************************************")
    }
}

// Function to simulate rolling the dice
fun rollDice(): Int {
    return Random.nextInt(1, 7)  // Generates a random number between 1 and 6
}
