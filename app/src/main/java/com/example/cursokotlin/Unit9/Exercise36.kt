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

class Exercise36 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Project36(modifier = Modifier, navController = rememberNavController())
        }
    }
}

@Composable
fun Project36(modifier: Modifier = Modifier, navController: NavHostController) {
    var numPeople by remember { mutableStateOf("") }  // For the number of people
    var height by remember { mutableStateOf("") }     // To enter the height
    var totalHeights by remember { mutableStateOf(0) }  // Counter for entered heights
    var sumHeights by remember { mutableStateOf(0.0) } // Total sum of heights
    var average by remember { mutableStateOf(0.0) }    // Final average of heights
    var heightsRemaining by remember { mutableStateOf(0) } // Control of remaining heights

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (heightsRemaining == 0) {
            // Input to enter the number of people
            OutlinedTextField(
                value = numPeople,
                onValueChange = { numPeople = it },
                label = { Text("Number of people") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                singleLine = true,
            )
            Button(
                onClick = {
                    heightsRemaining = numPeople.toIntOrNull() ?: 0
                },
                modifier = Modifier.padding(10.dp)
            ) {
                Text(text = "Confirm number of people")
            }
        } else {
            // Input to enter the heights
            OutlinedTextField(
                value = height,
                onValueChange = { height = it },
                label = { Text("Enter height (e.g. 1.75)") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                singleLine = true,
            )

            Button(
                onClick = {
                    val heightDouble = height.toDoubleOrNull()
                    if (heightDouble != null) {
                        sumHeights += heightDouble
                        totalHeights += 1
                        heightsRemaining -= 1
                    }
                    height = ""

                    // Calculate average if all heights have been entered
                    if (heightsRemaining == 0 && totalHeights > 0) {
                        average = sumHeights / totalHeights
                    }
                },
                modifier = Modifier.padding(10.dp)
            ) {
                Text(text = "Enter height ($totalHeights/${numPeople})")
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Heights remaining: $heightsRemaining",
                modifier = Modifier.padding(10.dp)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Display the average once all heights have been entered
        if (heightsRemaining == 0 && totalHeights > 0) {
            Text(
                text = "Average height: ${"%.2f".format(average)} meters",
                modifier = Modifier.padding(10.dp)
            )
        }
    }
}
