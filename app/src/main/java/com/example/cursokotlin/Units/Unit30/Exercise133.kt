package com.example.cursokotlin.Units.Unit30

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
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
    val scrollState = rememberScrollState()

    fun runDemo() {
        outputText = buildString {
            Countries.values().forEach { country ->
                if (isNotEmpty()) {
                    append("\n\n")
                }
                append("Country: ${country.name}")
                append("\nPopulation: ${country.population}")
            }
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { runDemo() },
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            Text("Show Country Info")
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(scrollState)
                .padding(8.dp)
        ) {
            Text(
                text = outputText,
                textAlign = TextAlign.Start,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }

    // Run the demo automatically when the composable is first created
    LaunchedEffect(Unit) {
        runDemo()
    }
}