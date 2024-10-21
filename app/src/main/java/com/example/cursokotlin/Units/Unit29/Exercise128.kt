package com.example.cursokotlin.Units.Unit29

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

data class Article(var code: Int, var description: String, var price: Float)

@Composable
fun Project128(modifier: Modifier = Modifier, navController: NavHostController) {
    var outputText by remember { mutableStateOf("") }

    fun updateOutput(text: String) {
        outputText += text + "\n"
    }

    fun runDemo() {
        outputText = "" // Clear previous output
        val article1 = Article(1, "potatoes", 34f)
        val article2 = Article(2, "apples", 24f)
        updateOutput(article1.toString())
        updateOutput(article2.toString())

        val pointer = article1
        pointer.price = 100f
        updateOutput(article1.toString())

        val article3 = article1.copy()
        article1.price = 200f
        updateOutput(article1.toString())
        updateOutput(article3.toString())

        if (article1 == article3) {
            updateOutput("They are equal $article1 and $article3")
        } else {
            updateOutput("They are different $article1 and $article3")
        }

        article3.price = 200f
        if (article1 == article3) {
            updateOutput("They are equal $article1 and $article3")
        } else {
            updateOutput("They are different $article1 and $article3")
        }
    }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { runDemo() }) {
            Text("Run Demo")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = outputText)
    }
}