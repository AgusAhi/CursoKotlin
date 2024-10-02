package com.example.cursokotlin.Unit11

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

class Exercise50 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Project50(modifier = Modifier, navController = rememberNavController())
        }
    }
}

@Composable
fun Project50(modifier: Modifier = Modifier, navController: NavHostController) {
    var mult3 by remember { mutableStateOf(0) }
    var mult5 by remember { mutableStateOf(0) }
    var mult9 by remember { mutableStateOf(0) }
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                for (i in 1..10000) {
                    if (i % 3 == 0) {
                        mult3++
                    }
                    if (i % 5 == 0) {
                        mult5++
                    }
                    if (i % 9 == 0) {
                        mult9++
                    }
                }
            },
            modifier = Modifier.padding(10.dp)
        ) {
            Text(text = "Start")
        }
        Text(
            text = "Multiples of 3: $mult3\n" +
                    "Multiples of 5: $mult5\n" +
                    "Multiples of 9: $mult9",
            modifier = Modifier.padding(10.dp)
        )
    }
}
