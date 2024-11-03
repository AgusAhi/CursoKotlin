package com.example.cursokotlin.Units.Unit30

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

enum class CardSuit {
    DIAMOND, CLUB, HEART, SPADE
}

class Card(val suit: CardSuit, val value: Int) {
    fun print(): String {
        return "Card: $suit and its value is $value"
    }
}

@Composable
fun Project131(modifier: Modifier = Modifier, navController: NavHostController) {
    var outputText by remember { mutableStateOf("") }

    fun runDemo() {
        val card1 = Card(CardSuit.CLUB, 4)
        val card2 = Card(CardSuit.DIAMOND, 10)
        val card3 = Card(CardSuit.SPADE, 7)
        val card4 = Card(CardSuit.HEART, 3)
        outputText = card1.print()
        outputText += "\n" + card2.print()
        outputText += "\n" + card3.print()
        outputText += "\n" + card4.print()
    }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { runDemo() }) {
            Text("Draw Card")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = outputText)
    }

    // Run the demo automatically when the composable is first created
    LaunchedEffect(Unit) {
        runDemo()
    }
}