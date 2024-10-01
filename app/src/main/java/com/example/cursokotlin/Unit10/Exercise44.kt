package com.example.cursokotlin.Unit9

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

class Exercise44 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Project44(modifier = Modifier, navController = rememberNavController())
        }
    }
}

@Composable
fun Project44(modifier: Modifier = Modifier, navController: NavHostController) {
    var currentWeight by remember { mutableStateOf("") } // Input for current piece weight
    var piecesBetween98And102 by remember { mutableStateOf(0) } // Counter for pieces between 9.8 and 10.2 kg
    var piecesAbove102 by remember { mutableStateOf(0) } // Counter for pieces above 10.2 kg
    var piecesBelow98 by remember { mutableStateOf(0) } // Counter for pieces below 9.8 kg
    var totalPieces by remember { mutableStateOf(0) } // Total number of pieces processed
    var resultMessage by remember { mutableStateOf("") } // Display result message
    var isProcessFinished by remember { mutableStateOf(false) } // Tracks whether the process is done

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Input field for the user to enter the weight of the piece
        if (!isProcessFinished) {
            OutlinedTextField(
                value = currentWeight,
                onValueChange = { currentWeight = it },
                label = { Text("Enter the weight of the piece (0 to finish)") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                singleLine = true,
            )

            Button(
                onClick = {
                    val weight = currentWeight.toDoubleOrNull()
                    if (weight != null) {
                        if (weight == 0.0) {
                            // Finish the process when weight is 0
                            isProcessFinished = true
                            val totalProcessed = piecesBetween98And102 + piecesAbove102 + piecesBelow98
                            resultMessage = """
                                Pieces between 9.8 kg and 10.2 kg: $piecesBetween98And102
                                Pieces above 10.2 kg: $piecesAbove102
                                Pieces below 9.8 kg: $piecesBelow98
                                Total pieces processed: $totalProcessed
                            """.trimIndent()
                        } else {
                            // Categorize the piece according to its weight
                            totalPieces++
                            when {
                                weight > 10.2 -> piecesAbove102++
                                weight >= 9.8 -> piecesBetween98And102++
                                weight > 0 -> piecesBelow98++
                            }
                        }
                        currentWeight = "" // Reset the input field
                    }
                },
                modifier = Modifier.padding(10.dp)
            ) {
                Text(text = "Add piece")
            }
        } else {
            // Show result summary after finishing the process
            Text(
                text = resultMessage,
                modifier = Modifier.padding(10.dp)
            )
        }
    }
}
