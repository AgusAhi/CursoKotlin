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

class Exercise40 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Project40(modifier = Modifier, navController = rememberNavController())
        }
    }
}

@Composable
fun Project40(modifier: Modifier = Modifier, navController: NavHostController) {
    var value1rest by remember { mutableStateOf("") }  // For entering values for the first list
    var value2rest by remember { mutableStateOf("") }  // For entering values for the second list
    var sum1 by remember { mutableStateOf(0) }  // Accumulated sum for the first list
    var sum2 by remember { mutableStateOf(0) }  // Accumulated sum for the second list
    var count1 by remember { mutableStateOf(0) }  // Counter for values in the first list
    var count2 by remember { mutableStateOf(0) }  // Counter for values in the second list
    var canProceed by remember { mutableStateOf(false) }  // Controls if we can proceed to the second list

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (!canProceed) {
            // Enter values for the first list
            OutlinedTextField(
                value = value1rest,
                onValueChange = { value1rest = it },
                label = { Text("Enter values for the first list (5 required)") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                singleLine = true,
            )
            Button(
                onClick = {
                    val value = value1rest.toIntOrNull()
                    if (value != null && count1 < 5) {
                        sum1 += value
                        count1 += 1
                    }
                    value1rest = ""

                    // Check if 5 values have been entered for the first list
                    if (count1 == 5) {
                        canProceed = true
                    }
                },
                modifier = Modifier.padding(10.dp)
            ) {
                Text(text = "Add value to the first list ($count1/5)")
            }
        } else if (count2 < 5) {
            // Enter values for the second list (only if the first list has 5 values)
            OutlinedTextField(
                value = value2rest,
                onValueChange = { value2rest = it },
                label = { Text("Enter values for the second list (5 required)") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                singleLine = true,
            )
            Button(
                onClick = {
                    val value = value2rest.toIntOrNull()
                    if (value != null && count2 < 5) {
                        sum2 += value
                        count2 += 1
                    }
                    value2rest = ""
                },
                modifier = Modifier.padding(10.dp)
            ) {
                Text(text = "Add value to the second list ($count2/5)")
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Show result only when both lists have 5 values
        if (count1 == 5 && count2 == 5) {
            Text(text = "Sum of the first list: $sum1")
            Text(text = "Sum of the second list: $sum2")

            // Compare the sums directly
            if (sum1 > sum2) {
                Text(text = "The first list is larger.")
            } else if (sum1 < sum2) {
                Text(text = "The second list is larger.")
            } else {
                Text(text = "Both lists are equal.")
            }
        }
    }
}
