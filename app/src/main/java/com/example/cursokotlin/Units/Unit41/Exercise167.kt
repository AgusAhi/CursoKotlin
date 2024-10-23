package com.example.cursokotlin.Units.Unit41

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

class DiceRoller {
    private val diceArray = IntArray(10)

    fun rollAll() {
        for (i in diceArray.indices) {
            diceArray[i] = ((Math.random() * 6) + 1).toInt()
        }
    }

    operator fun invoke(index: Int) = diceArray[index]
}

@Composable
fun Project167(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    var diceRoller by remember { mutableStateOf(DiceRoller()) }
    var hasRolled by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = "Dice Roller",
            style = MaterialTheme.typography.headlineMedium
        )

        Button(
            onClick = {
                diceRoller.rollAll()
                hasRolled = true
            }
        ) {
            Text("Roll All Dice")
        }

        if (hasRolled) {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                items(10) { index ->
                    Text("Dice ${index + 1}: ${diceRoller(index)}")
                }
            }
        }
    }
}