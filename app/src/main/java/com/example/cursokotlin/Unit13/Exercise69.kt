package com.example.cursokotlin.Unit5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

class Exercise69 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Project69(modifier = Modifier, navController = rememberNavController())
        }
    }
}

@Composable
fun Project69(modifier: Modifier = Modifier, navController: NavHostController) {
    var childCount by remember { mutableStateOf("") }
    var familiesWithZeroChildren by remember { mutableStateOf(0) }
    var familiesWithOneChild by remember { mutableStateOf(0) }
    var familiesWithTwoChildren by remember { mutableStateOf(0) }
    var familiesWithMoreThanTwoChildren by remember { mutableStateOf(0) }
    var currentFamilyCount by remember { mutableStateOf(1) }
    var finished by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        if (!finished) {
            Text("Enter the number of children for family #$currentFamilyCount:")

            OutlinedTextField(
                value = childCount,
                onValueChange = { childCount = it },
                label = { Text("Number of children") },
                modifier = Modifier.fillMaxWidth()
            )

            Button(
                onClick = {
                    val numberOfChildren = childCount.toIntOrNull()
                    if (numberOfChildren != null) {
                        when (numberOfChildren) {
                            0 -> familiesWithZeroChildren++
                            1 -> familiesWithOneChild++
                            2 -> familiesWithTwoChildren++
                            else -> familiesWithMoreThanTwoChildren++
                        }
                        currentFamilyCount++
                        childCount = "" // Clear input field

                        if (currentFamilyCount > 10) {
                            finished = true // Mark as finished after 10 inputs
                        }
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Submit")
            }
        } else {
            // Display results after 10 inputs
            Text("Number of families with 0 children: $familiesWithZeroChildren")
            Text("Number of families with 1 child: $familiesWithOneChild")
            Text("Number of families with 2 children: $familiesWithTwoChildren")
            Text("Number of families with more than 2 children: $familiesWithMoreThanTwoChildren")
        }
    }
}
