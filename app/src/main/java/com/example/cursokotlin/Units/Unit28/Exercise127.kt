package com.example.cursokotlin.Units.Unit28

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun Project127(modifier: Modifier = Modifier, navController: NavHostController) {
    var dieValue by remember { mutableStateOf(1) }
    val die = remember { Die(7) }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Die value: $dieValue")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            die.roll()
            dieValue = die.value
        }) {
            Text("Roll the die")
        }
    }

    LaunchedEffect(Unit) {
        die.print()
        die.roll()
        die.print()
    }
}

class Die(value: Int) {
    var value: Int = 1
        set(value) {
            field = if (value in 1..6) value else 1
        }

    init {
        this.value = value
    }

    fun roll() {
        value = ((Math.random() * 6) + 1).toInt()
    }

    fun print() = println("Die value: $value")
}