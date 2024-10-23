package com.example.cursokotlin.Units.Unit30

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

enum class Countries(val population: Int) {
    BRAZIL(202450649),
    COLOMBIA(50364000),
    PERU(31151643),
    VENEZUELA(31028337),
    CHILE(18261884),
    ECUADOR(16298217),
    BOLIVIA(10888000),
    PARAGUAY(6460000),
    URUGUAY(3372000)
}

@Composable
fun Project133(modifier: Modifier = Modifier, navController: NavHostController) {
    var outputText by remember { mutableStateOf("") }

    fun runDemo() {
        val country1 = Countries.BRAZIL
        outputText = "Country: $country1\nPopulation: ${country1.population}"
    }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { runDemo() }) {
            Text("Show Country Info")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = outputText)
    }

    // Run the demo automatically when the composable is first created
    LaunchedEffect(Unit) {
        runDemo()
    }
}