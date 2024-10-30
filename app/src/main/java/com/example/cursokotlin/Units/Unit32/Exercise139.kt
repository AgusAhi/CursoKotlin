package com.example.cursokotlin.Units.Unit32

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

// Base class Dice
open class Dice {
    protected var value: Int = 1

    fun roll() {
        value = ((Math.random() * 6) + 1).toInt()
    }

    open fun print(): String {
        return value.toString()
    }
}

// Derived class BoxedDice with overridden print method
class BoxedDice : Dice() {
    override fun print(): String {
        return """
            ***
            *$value*
            ***
        """.trimIndent()
    }
}

// Jetpack Compose function
@Composable
fun Project139(navController: NavHostController, modifier: Modifier = Modifier) {
    var diceOutput by remember { mutableStateOf("") }
    var boxedDiceOutput by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        // Button to trigger the dice roll for the Dice class
        Button(onClick = {
            val dice1 = Dice()
            dice1.roll()
            diceOutput = "Dice Result: ${dice1.print()}"
        }) {
            Text(text = "Roll Dice", fontSize = 18.sp)
        }
        Text(text = diceOutput, fontSize = 16.sp, modifier = Modifier.padding(top = 8.dp))

        // Button to trigger the dice roll for the BoxedDice class
        Button(onClick = {
            val dice2 = BoxedDice()
            dice2.roll()
            boxedDiceOutput = "BoxedDice Result:\n${dice2.print()}"
        }, modifier = Modifier.padding(top = 16.dp)) {
            Text(text = "Roll Boxed Dice", fontSize = 18.sp)
        }
        Text(text = boxedDiceOutput, fontSize = 16.sp, modifier = Modifier.padding(top = 8.dp))
    }
}
